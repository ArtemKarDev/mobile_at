package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OnboardingScreen {
    private final SelenideElement
            onboardingTitle = $(".onboarding__title"),
            continueButton = $(".onboarding__button"),
            getStartedButton = $(".onboarding__button");

}
