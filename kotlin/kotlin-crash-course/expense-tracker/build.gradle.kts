
plugins {
    application
}

application{
    mainClass.set("MainKt")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
}