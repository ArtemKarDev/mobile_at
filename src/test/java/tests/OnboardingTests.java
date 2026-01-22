package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.OnboardingScreen;

public class OnboardingTests extends TestBase {

    OnboardingScreen onboardingPage = new OnboardingScreen();

    @Test
    @Tag("onboarding")
    @Description("Проверка прохождения onboarding")
    void onboardingFlowTest() {
        onboardingPage
                .shouldHaveTitle("The Free Encyclopedia\n…in over 300 languages")
                .clickContinue()
                .shouldHaveTitle("New ways to explore")
                .clickContinue()
                .shouldHaveTitle("Reading lists")
                .clickContinue()
                .shouldHaveTitle("Send anony")
                .clickGetStarted();
    }
}