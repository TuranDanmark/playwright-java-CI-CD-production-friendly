package com.elvira.tests;

import com.elvira.base.BaseTest;
import com.elvira.pages.HomePage;
import com.elvira.utils.TestListener;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@ExtendWith(TestListener.class)
public class HomePageTest extends BaseTest {

    @Tag("regression")
    @Test
    void UserCanOpenDocsPage() {

        HomePage homePage = new HomePage(page);

        homePage.navigate();
        homePage.clickGetStarted();

    assertThat(page.locator("text=Get started")).isVisible();

}

}