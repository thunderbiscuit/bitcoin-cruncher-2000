plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
    id("org.gradle.application")
}

group = "me.tb"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("com.github.ajalt.clikt:clikt:4.2.1")
    implementation("com.github.ajalt.mordant:mordant:2.2.0")

    // Bitcoin libraries
    implementation("me.tb:bitcoin-tx-parser:0.1.1-SNAPSHOT")
    implementation("me.tb:bitcoin-block-parser:0.1.0-SNAPSHOT")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("me.tb.MainKt")
    applicationName = "cruncher"
}
