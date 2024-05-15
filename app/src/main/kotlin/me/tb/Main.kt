package me.tb

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import me.tb.commands.Block
import me.tb.commands.Tx

fun main(args: Array<String>) = Cruncher()
    .subcommands(
        Tx(),
        Block(),
    )
    .main(args)

class Cruncher : CliktCommand(help = "Crunch bitcoin data like you mean it!") {
    override fun run() = Unit
}
