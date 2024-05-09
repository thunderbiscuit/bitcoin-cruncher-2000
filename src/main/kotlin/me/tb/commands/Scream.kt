package me.tb.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument

class Scream : CliktCommand(help = "Repeats really loud") {
    val message: String by argument(help = "The message to scream")

    override fun run() {
        echo(message.uppercase())
    }
}
