package me.tb.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.clikt.parameters.types.int
import me.tb.Block
import java.io.File

@OptIn(ExperimentalUnsignedTypes::class)
class Block : CliktCommand(help = "Parse a transaction") {
    private val file by option(help = "The file containing the block").required()
    private val number by option(help = "The number of transactions to parse").int()

    override fun run() {
        val fileBytes: UByteArray = File(file).readBytes().toUByteArray()
        val block: Block = Block(fileBytes)
        val numberOfTransactionsToParse = number

        echo("Block header: ${block.blockHeader}")
        echo("Number of transactions: ${block.txCount}")

        if (numberOfTransactionsToParse != null) {
            block.parseTransactions(numberOfTransactionsToParse)
        } else {
            block.parseTransactions()
        }
    }
}
