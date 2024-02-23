plugins {
	java
	war
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "hello"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	//JSP 추가 시작
	implementation ("org.apache.tomcat.embed:tomcat-embed-jasper")
	implementation ("jakarta.servlet:jakarta.servlet-api") //스프링부트 3.0 이상
	implementation ("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api") //스프링부트 3.0 이상
	implementation ("org.glassfish.web:jakarta.servlet.jsp.jstl") //스프링부트 3.0 이상
	//JSP 추가 끝

//	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
