package me.tb

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import me.tb.commands.Colors
import me.tb.commands.Errors
import me.tb.commands.Play
import me.tb.commands.Scream

// The first command is the one that is run by default when the user calls the cli.
// fun main(args: Array<String>) = KS().main(args)

// You can add subcommands to that initial command.
fun main(args: Array<String>) = KS()
    .subcommands(Colors(), Scream(), Errors(), Play())
    .main(args)

class KS : CliktCommand(help = "A sample Kotlin CLI tool") {
    override fun run() = Unit
    // override fun run() {
    //     echo("Hello, World!")
    // }
}
