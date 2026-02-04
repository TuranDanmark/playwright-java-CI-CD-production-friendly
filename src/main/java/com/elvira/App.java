package com.elvira;

import com.microsoft.playwright.*;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page page = browser.newPage();

            page.navigate("https://playwright.dev/");

            // Клик по кнопке Get started
            page.locator("text=Get started").click();

            // Проверяем URL
            System.out.println("Current URL: " + page.url());

            page.waitForTimeout(5000);
            browser.close();
        }
    }
}
