package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingScreen {
    private final SelenideElement
            onboardingTitle = $(id("org.wikipedia:id/view_onboarding_page_primary_text")),
            continueButton = $(id("org.wikipedia:id/fragment_onboarding_forward_button")),
            getStartedButton = $(id("org.wikipedia:id/fragment_onboarding_done_button")),
            skipButton = $(id("org.wikipedia:id/fragment_onboarding_skip_button"));

    @Step("Проверика заголовка onboarding экрана: {expectedText}")
    public OnboardingScreen shouldHaveTitle(String expectedText) {
        onboardingTitle.shouldBe(visible).shouldHave(com.codeborne.selenide.Condition.text(expectedText));
        return this;
    }

    @Step("Нажать Continue")
    public OnboardingScreen clickContinue() {
        continueButton.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать Get started")
    public void clickGetStarted() {
        getStartedButton.shouldBe(visible).click();
    }

    @Step("Нажать skip")
    public SearchScreen clickSkip() {
        skipButton.shouldBe(visible).click();
        return new SearchScreen();
    }


}
