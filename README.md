# 🚀 Playwright Java CI/CD Production-Friendly Framework

[![CI Pipeline](https://github.com/TuranDanmark/playwright-java-CI-CD-production-friendly/actions/workflows/ci.yml/badge.svg)](https://github.com/TuranDanmark/playwright-java-CI-CD-production-friendly/actions/workflows/ci.yml)

## 📌 Overview

Production-ready UI Automation framework built with:

- ✅ Playwright (Java)
- ✅ JUnit 5
- ✅ Allure Reporting
- ✅ Docker execution
- ✅ GitHub Actions CI/CD
- ✅ GitHub Pages deployment
- ✅ Smoke & Regression test tagging
- ✅ Multi-browser support (Chromium / Firefox / WebKit)

---

## 📊 Live Allure Report

👉 **Allure Report:**  
https://turandanmark.github.io/playwright-java-CI-CD-production-friendly/

The report is automatically generated in CI and deployed to the `gh-pages` branch.

---

## 🧱 Tech Stack

- Java 17+
- Maven
- Playwright
- JUnit 5
- Allure Maven Plugin
- Docker
- GitHub Actions

---

## 📂 Project Structure

playwright-java-CI-CD-production-friendly
│
├── src/test/java
│ ├── base
│ ├── core
│ ├── tests
│ └── utils
│
├── .github/workflows
│ └── ci.yml
│
├── Dockerfile
├── pom.xml
└── README.md


---

## 🌍 Browser Support

Framework uses enum-based browser selection:

```java
public enum SupportedBrowser {
    CHROMIUM,
    FIREFOX,
    WEBKIT;

    public static SupportedBrowser from(String value) {
        return SupportedBrowser.valueOf(value.toUpperCase());
    }
}
Run with:

mvn clean test -Dbrowser=firefox
Available values:

chromium (default)

firefox

webkit

🧪 Test Types
Tests are separated by JUnit 5 tags:

@Tag("smoke")

@Tag("regression")

Run smoke tests only:

mvn clean test -Dgroups=smoke
Run regression suite:

mvn clean test -Dgroups=regression
▶️ Local Execution
Install Playwright Browsers
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install --with-deps"
Run Tests
mvn clean test -Dheadless=true
Generate Allure Report
mvn allure:report
Open Allure Report
mvn allure:serve
🐳 Docker Execution
Build image:

docker build -t playwright-tests .
Run tests inside container:

docker run --rm playwright-tests
Docker image uses official Playwright Java image with preinstalled browsers.

🔁 CI/CD Pipeline
GitHub Actions workflow performs:

Checkout repository

Build Docker image

Execute tests

Generate Allure report

Publish report to gh-pages

CI is triggered on:

push

pull request

⚙️ Configuration Parameters
You can control execution via JVM properties:

Property	Description	Example
browser	Select browser	-Dbrowser=firefox
headless	Run in headless mode	-Dheadless=false
timeout	Global timeout (ms)	-Dtimeout=10000
📈 Allure Integration
Allure plugin generates report at:

target/site/allure-maven-plugin
Results directory:

target/allure-results
CI publishes generated static report to GitHub Pages automatically.

🎯 Key Features
Thin BaseTest architecture

Enum-driven browser selection

Clean separation of config layer

Parallel-ready structure

CI-friendly setup

Docker-ready execution

Production-ready design

👩‍💻 Author
TuranAmran
QA Automation Engineer
Denmark

