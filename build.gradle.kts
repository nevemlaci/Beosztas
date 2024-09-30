plugins {
    id("java")
}

group = "org.nevemlaci.schedule"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.formdev:flatlaf:3.0")
    implementation("org.apache.poi:poi:5.3.0")
    implementation("org.apache.poi:poi-ooxml:5.3.0")
}

tasks.test {
    useJUnitPlatform()
}