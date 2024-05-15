package me.tb.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.mordant.rendering.TextAlign
import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.TextStyles
import com.github.ajalt.mordant.table.Borders
import com.github.ajalt.mordant.table.ColumnWidth
import com.github.ajalt.mordant.table.table
import com.github.ajalt.mordant.terminal.Terminal
import me.tb.txparser.Tx
import me.tb.txparser.txelements.Locktime

@OptIn(ExperimentalStdlibApi::class, ExperimentalUnsignedTypes::class)
class Tx : CliktCommand(help = "Parse a transaction") {
    private val hex by option(help = "The raw transaction hex").required()

    override fun run() {
        val rawTx = hex.hexToUByteArray()
        val tx: Tx = Tx.fromBytes(rawTx)
        val locktime: String = when (tx.locktime) {
            is Locktime.Blocks -> "Block-based timelock: ${(tx.locktime as Locktime.Blocks).height}"
            is Locktime.Time   -> "Time-based timelock: ${(tx.locktime as Locktime.Time).timestamp}"
        }
        echo()

        val t = Terminal()
        t.println(
            table {
                tableBorders = Borders.BOTTOM

                column(0) { width = ColumnWidth.Fixed(16) }
                column(1) { width = ColumnWidth.Fixed(90) }

                header {
                    style = TextColors.brightGreen + TextStyles.bold
                    row {
                        cell("Transaction Data") {
                            columnSpan = 2
                            align = TextAlign.CENTER
                            cellBorders = Borders.NONE
                        }
                    }
                }

                body {
                    row("Version", tx.version.value.toString()) { cellBorders = Borders.ALL }
                    row("SegWit", tx.segWit.toString()) { cellBorders = Borders.ALL }
                    row("Num Inputs", tx.inputs.size.toString()) { cellBorders = Borders.ALL }
                    tx.inputs.forEachIndexed { index, input ->
                        row("Input $index", "") { cellBorders = Borders.ALL }
                        row("  Outpoint", "${input.outPoint.txid}:${input.outPoint.vout}") { cellBorders = Borders.ALL }
                        row("  ScriptSig", input.scriptSig.bytes.toHexString().breakAt(88)) { cellBorders = Borders.ALL }
                        row("  Sequence", input.sequence.bytes.toHexString()) { cellBorders = Borders.ALL }
                    }
                    row("Num Outputs", tx.outputs.size.toString()) { cellBorders = Borders.ALL }
                    tx.outputs.forEachIndexed { index, output ->
                        row("Output $index", "") { cellBorders = Borders.ALL }
                        row("  Amount", output.outputAmount.value.toString()) { cellBorders = Borders.ALL }
                        row("  ScriptPubKey", output.scriptPubKey.bytes.toHexString().breakAt(88)) { cellBorders = Borders.ALL }
                    }
                    row("Locktime", locktime) { cellBorders = Borders.ALL }
                }
            }
        )
        echo()
    }
}

fun String.breakAt(length: Int): String {
    return this.chunked(length).joinToString("\n")
}
