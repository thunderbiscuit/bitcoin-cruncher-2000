package me.tb.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required

class Errors : CliktCommand(help = "Print to stderr") {
    private val message by option(help = "The message to print").required()

    override fun run() {
        echo(
            message = message,
            err = true
        )
    }
}
