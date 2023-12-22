plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.21"
    id("com.google.devtools.ksp") version "1.9.21-1.0.15"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.2.1"
}

version = "0.1"
group = "be.hartraft"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    ksp("info.picocli:picocli-codegen")
    ksp("io.micronaut.serde:micronaut-serde-processor")
    implementation("info.picocli:picocli")
    implementation("info.picocli:picocli-shell-jline3:4.7.5")
    implementation("org.fusesource.jansi:jansi:2.4.1")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
}


application {
    mainClass.set("be.hartraft.KebabDbCommand")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
}


micronaut {
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("be.hartraft.*")
    }
}



