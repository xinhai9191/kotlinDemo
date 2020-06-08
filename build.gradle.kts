import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.3.72"
	id("org.springframework.boot") version "2.2.2.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	id("org.asciidoctor.convert") version "1.5.8"
	id("org.jetbrains.dokka") version "0.9.18"
	id("com.google.cloud.tools.jib") version "1.8.0"
	id("com.github.johnrengelman.shadow") version "5.2.0"
	id("nu.studer.jooq") version "4.1"
	id("com.palantir.git-version") version "0.12.3"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("mysql:mysql-connector-java")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

	implementation("org.jooq:jooq:3.13.1")
	implementation("org.jooq:jooq-meta:3.13.1")
	implementation("org.jooq:jooq-codegen:3.13.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

apply(from = "jooq.gradle")