plugins {
    id("java")
}

group = "com.tatsuyafujisaki"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit)
}
