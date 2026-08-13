plugins {
    kotlin("jvm") version "2.2.20" apply false   // declare version once, don't apply to root
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
        jvmToolchain(17)
    }

    dependencies {
        "testImplementation"(kotlin("test"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}