plugins {
    id("com.gradleup.shadow") version "8.3.2"
    id("java")
}

group = "org.nevemlaci.schedule"
version = ""

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.formdev:flatlaf:3.0")
    implementation("org.apache.poi:poi:5.3.0")
    implementation("org.apache.poi:poi-ooxml:5.3.0")
    implementation("org.json:json:20240303")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar{
    archiveBaseName.set("schedule")
    manifest {
        attributes["Main-Class"] = "org.nevemlaci.schedule.Main"
    }
}

tasks.shadowJar{
        archiveBaseName.set("schedule")
    manifest {
        attributes["Main-Class"] = "org.nevemlaci.schedule.Main"
    }
}