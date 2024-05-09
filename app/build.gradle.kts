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
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("me.tb.MainKt")
    applicationName = "ks"
}
