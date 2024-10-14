plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.3"
}

group = "org.nevemlaci.schedule"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.formdev:flatlaf:3.5.2-SNAPSHOT")
    implementation("org.apache.poi:poi:5.3.0")
    implementation("org.apache.poi:poi-ooxml:5.3.0")
    implementation("org.json:json:20240303")

}

tasks.test {
    useJUnitPlatform()
}

tasks.jar{
    manifest{
        attributes["Main-Class"] = "org.nevemlaci.schedule.Main"
    }
}
