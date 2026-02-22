plugins {
    kotlin("jvm") version "2.2.21"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies {
    // Appium Java client
    implementation("io.appium:java-client:10.0.0")

    // Cucumber
    testImplementation("io.cucumber:cucumber-java:7.34.2")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.34.2")

    // JUnit Platform
    testImplementation("org.junit.platform:junit-platform-suite:1.10.2")

    // Assertions
    testImplementation("org.assertj:assertj-core:3.27.7")

    // Logging (required by Appium)
    testImplementation("org.slf4j:slf4j-simple:2.0.17")

    //allure for reporting
//    testImplementation("io.qameta.allure:allure-cucumber6-jvm:2.33.0")

}

tasks.withType<Test> {
    systemProperty(
        "platform",
        System.getProperty("platform", "android")
    )
}

tasks.test {
    useJUnitPlatform()
    outputs.upToDateWhen { false }

    // Log the report URL to the console on completion
    addTestListener(object : TestListener {
        override fun afterSuite(suite: TestDescriptor, result: TestResult) {
            if (suite.parent == null) {
                println("\nTest Report available at: file://${reports.html.outputLocation.get()}/index.html")
            }
        }
        override fun beforeSuite(suite: TestDescriptor) {}
        override fun beforeTest(test: TestDescriptor) {}
        override fun afterTest(test: TestDescriptor, result: TestResult) {}
    })
}