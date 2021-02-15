import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
}

group = "net.xenotime"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://repo.opencollab.dev/maven-snapshots/")
    maven(url = "https://raw.github.com/JRakNet/WaifUPnP/master/")
    maven(url = "https://repo.codemc.org/repository/maven-public/")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
dependencies {
    implementation(kotlin("reflect"))
    implementation("com.whirvis:jraknet:2.12.3")
    //Todo: implement native zlib
}
