package me.tb.commands

import com.github.ajalt.clikt.core.CliktCommand

class Colors : CliktCommand(help = "Show some colors") {
    override fun run() {
        echo("Hello, Colors!")
    }
}
