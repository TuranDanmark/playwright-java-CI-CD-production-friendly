package com.elvira;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class PlaywrightTest {

    Playwright playwright;
    Browser browser;
    Page page;

@BeforeEach
void setUp() {
    playwright = Playwright.create();

    boolean headless = Boolean.parseBoolean(
            System.getProperty("headless", "false")
    );

    browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions()
                    .setHeadless(headless)
                    .setSlowMo(200)
    );

    page = browser.newPage();
}

    @Test
    void openPlaywrightSite() {
        page.navigate("https://playwright.dev/");
        page.locator("text=Get started").click();

        Assertions.assertTrue(page.url().contains("docs"));
    }

    @AfterEach
    void tearDown() {
        browser.close();
        playwright.close();
    }
}
