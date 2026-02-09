package com.elvira.base;

import com.elvira.config.Config;
import com.microsoft.playwright.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void writeEnvironmentInfo() {
    try {
        File resultsDir = new File("target/allure-results");
        if (!resultsDir.exists()) {
            resultsDir.mkdirs();
        }

        File envFile = new File(resultsDir, "environment.properties");

        try (PrintWriter writer = new PrintWriter(envFile)) {
            writer.println("Browser=Chromium");
            writer.println("Headless=" + System.getProperty("headless", "true"));
            writer.println("OS=" + System.getProperty("os.name"));
            writer.println("Java=" + System.getProperty("java.version"));
            writer.println("Environment=" + System.getProperty("env", "local"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @BeforeEach
    void setUp() {

        playwright = Playwright.create();

        BrowserType browserType;

        String browserName = System.getProperty("browser", "chromium");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(headless);


        switch (Config.browser().toLowerCase()) {
            case "firefox":
                browserType = playwright.firefox();
                break;
            case "webkit":
                browserType = playwright.webkit();
                break;
            default:
                browserType = playwright.chromium();
        }

        browser = browserType.launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(Config.headless())
        );

        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setRecordVideoDir(Paths.get("target/videos"))
        );

        context.setDefaultTimeout(Config.timeout());

        page = context.newPage();
        page.navigate(Config.baseUrl());
        page.navigate(Config.baseUrl1());
    }

    @AfterEach
    void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }


}