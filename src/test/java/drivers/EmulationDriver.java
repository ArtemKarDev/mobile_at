package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigReader;
import config.TestConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;


import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class EmulationDriver implements WebDriverProvider {

    private final TestConfig config = ConfigReader.INSTANCE.getConfig();

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(config.platformName())
                .setAutomationName("UiAutomator2")
                .setDeviceName(config.deviceName())
                .setAvd(config.deviceName())
                .setAppPackage(config.appPackage())
                .setAppActivity(config.appActivity())
                .setNoReset(false)
                .setAppWaitActivity("*");

        try {
            return new AndroidDriver(new URL(config.appiumUrl() + "/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid server URL", e);
        }
    }

}
