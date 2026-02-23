# Mobile Automation Framework - Kotlin + Appium + Cucumber

A **demo implementation** showcasing how to structure mobile automation tests for Compose Multiplatform applications using Kotlin, Appium, and Cucumber BDD.

## 📱 Project Overview

This project serves as a **reference implementation** demonstrating best practices for mobile test automation. It shows how to structure tests for the **RideYR** mobile application (a Compose Multiplatform app) using modern testing patterns including Page Object Model and Behavior-Driven Development (BDD).

⚠️ **Note**: This is a demonstration project only. The actual app files are not included, so the tests cannot be executed without the RideYR application.

## 🛠️ Tech Stack

- **Kotlin** - Modern JVM language for test implementation
- **Appium** - Cross-platform mobile automation framework
- **Cucumber** - BDD framework for writing tests in natural language
- **JUnit 5** - Testing platform with JUnit Platform Suite
- **AssertJ** - Fluent assertions library
- **Gradle** - Build and dependency management

## 🎬 Demo

![Kotlin Appium Cucumber Demo](assets/kotlin_appium_demo.gif)

*Example of automated mobile testing using Kotlin + Appium + Cucumber for the RideYR application*

## 📋 Technologies Demonstrated

This demo implementation showcases the integration of:

- **Java 11+** - Target JVM version for Kotlin compilation
- **Android Studio & Xcode** - Mobile development environments
- **Node.js & Appium Server** - Mobile automation infrastructure
- **Android SDK & iOS Simulator** - Target platform tools


## 🏗️ Project Structure

```
kotlin-appium-cucumber/
├── build.gradle.kts              # Build configuration
├── src/test/
│   ├── kotlin/
│   │   ├── driver/
│   │   │   └── DriverFactory.kt  # Appium driver initialization
│   │   ├── hooks/
│   │   │   └── Hooks.kt          # Cucumber Before/After hooks
│   │   ├── pages/
│   │   │   ├── BaseScreen.kt     # Base page class
│   │   │   ├── HomeScreen.kt     # Home screen page object
│   │   │   ├── ServiceAlertsModalScreen.kt
│   │   │   └── StopTimesScreen.kt
│   │   ├── runner/
│   │   │   └── TestRunner.kt     # Cucumber test runner
│   │   ├── steps/
│   │   │   └── HomeScreenSteps.kt # Step definitions
│   │   └── utils/
│   │       └── extensions.kt     # Utility functions
│   └── resources/
│       └── features/
│           └── homescreennavigation.feature # BDD scenarios
```



## 🤝 Using This Demo

This project serves as a reference implementation. You can:

1. **Study** the project structure and patterns
2. **Copy** implementation approaches for your own projects  
3. **Adapt** the Page Object Model and BDD patterns
4. **Reference** the cross-platform configuration strategies

### Key Implementation Patterns to Note
- **Page Object Model**: Clean separation of page logic and test steps
- **BDD with Cucumber**: Natural language test scenarios
- **Cross-Platform Support**: Unified codebase for Android and iOS
- **Modern Kotlin Patterns**: Leveraging Kotlin language features
- **Build Configuration**: Gradle setup for mobile automation

## 📚 Additional Resources

- [Appium Documentation](https://appium.io/docs/en/2.1/)
- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [Kotlin Language Guide](https://kotlinlang.org/docs/home.html)
- [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform/)

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

**Note**: This is a **demonstration project** showcasing mobile automation patterns and best practices. The RideYR app files are not included, making this a reference implementation for learning and adaptation rather than a runnable test suite.
