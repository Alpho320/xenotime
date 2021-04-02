import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    maven(url = "https://repo.nukkitx.com/maven-releases/")
    maven(url = "https://repo.nukkitx.com/maven-snapshots/")
}

plugins {
    kotlin("jvm") version "1.4.21"
    application
}

dependencies {
    implementation(project(":api"))
    implementation("com.nukkitx.protocol:bedrock-v428:2.6.3-SNAPSHOT")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

// TODO
application {
    mainClassName = ""
}
