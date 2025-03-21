plugins {
    id("java")
    id("application")
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core:nettee-jpa-core"))
    implementation(project(":common"))
    implementation(project(":services:board"))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    //spring boot
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    // database
    runtimeOnly("org.postgresql:postgresql:42.7.4")

    // flyway
    implementation("org.flywaydb:flyway-database-postgresql")
}

tasks.test {
    useJUnitPlatform()
}

tasks.bootJar {
    enabled = true
    mainClass.set("me.nettee.Main")
}

tasks.jar {
    enabled = false
}

tasks.named<JavaExec>("bootRun") {
    jvmArgs("--enable-preview")
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    mainClass.set("me.nettee.Main")
}

//application {
//    mainClass.set("me.nettee.Main")
//}

//tasks.withType<Jar> {
//    manifest {
//        attributes["Main-Class"] = "me.nettee.Main"
//    }
//}
//
//springBoot {
//    mainClass.set("me.nettee.Main")
//}