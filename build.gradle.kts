import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	java
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
}

repositories {
	mavenCentral()
	maven { url = uri("https://jitpack.io") }
}

allprojects {
	group = "me.nettee"
	version = "0.0.1-SNAPSHOT"

}

subprojects {
	apply {
		plugin("java")
		plugin("java-library")
		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
	}

	repositories {
		mavenCentral()
		maven { url = uri("https://jitpack.io") }
	}

	dependencies {
//		if (project.name != "common") {
//			api(project(":common"))
//		}

		compileOnly("org.springframework:spring-web")
		compileOnly("org.springframework:spring-context")

		compileOnly("org.projectlombok:lombok")
		annotationProcessor("org.projectlombok:lombok")
	}
}

//sourceSets {
//	main {
//		resources {
//			setSrcDirs(listOf("monolithic/src/main/resources"))
//		}
//	}
//}
