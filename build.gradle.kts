plugins {
    id("java")
}

group = "com.tatsuyafujisaki"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.gson)
    implementation(libs.json)
    testImplementation(libs.junit)
}
