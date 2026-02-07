package com.elvira.tests;

import com.elvira.base.BaseTest;
import com.elvira.pages.HomePage;
import com.elvira.utils.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@ExtendWith(TestListener.class)
@Epic("Todo App")
@Feature("Todo Management")
public class HomePageTest extends BaseTest {

    @Tag("regression")
    @Test
    @Story("User can click Get started")
    @Description("Verify that user can asserthat Get started")
    @Severity(SeverityLevel.CRITICAL)
    void UserCanOpenDocsPage() {

        HomePage homePage = new HomePage(page);

        homePage.navigate();
        homePage.clickGetStarted();

    assertThat(page.locator("text=Get started")).isVisible();

}

}