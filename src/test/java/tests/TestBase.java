package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.DriverProvider;
import com.codeborne.selenide.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {

    @BeforeAll
    static  void setupDriver() {
        Configuration.browser = DriverProvider.getDriver();
        Configuration.browserSize = null;
//        Configuration.timeout = 30000;
//
//        Configuration.remoteConnectionTimeout = 10000;
//        Configuration.remoteReadTimeout = 60000;

    }

    @BeforeEach
    void addListenerAndOpen() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
//        String sessionId = Selenide.sessionId().toString();
//        Attach.pageSource();
//        try { Attach.screenshotAs("Last screenshot"); } catch (Exception ignored) {}
//        try { Attach.pageSource(); } catch (Exception ignored) {}
        closeWebDriver();

//        Attach.addVideo(sessionId);
    }
}
