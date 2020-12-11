plugins {
    java
    application
}

application {
    mainClassName = "yitian.study.helloworld.HelloWorld"
}

java {
    sourceCompatibility = JavaVersion.VERSION_14
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:28.2-jre")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    implementation("com.h2database:h2:1.4.196")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
    options.compilerArgs.add("-Xlint:preview")
}
tasks.withType<JavaExec> {
    jvmArgs("--enable-preview")
}
tasks.test {
    jvmArgs("--enable-preview")
}