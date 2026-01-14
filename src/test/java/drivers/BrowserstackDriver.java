package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigReader;
import config.TestConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        TestConfig config = ConfigReader.INSTANCE.getConfig();

        MutableCapabilities caps = new MutableCapabilities();

        String browserstackUser = config.browserstackUser();
        String browserstackKey = config.browserstackKey();

        if (browserstackUser == null || browserstackKey == null) {
            throw new IllegalArgumentException("Browserstack credentials are not set" +
                    "Use: -Dbrowserstack.user=YOUR_USER -Dbrowserstack.key=YOUR_KEY");
        }

        caps.setCapability("browserstack.user", browserstackUser);
        caps.setCapability("browserstack.key", browserstackKey);

        caps.setCapability("project", config.project());
        caps.setCapability("build", config.buildName());
        caps.setCapability("session", config.testName());

        caps.setCapability("app", config.app());


        caps.setCapability("device", config.deviceName());
        caps.setCapability("osVersion", config.platformVersion());
        caps.setCapability("appium:automationName", config.appiumAutomationName());


        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack URL", e);
        }

    }

}
