package drivers;

import com.codeborne.selenide.WebDriverProvider;

public class DriverProvider {
        public static WebDriverProvider getDriver() {

            String deviceHost =
                    System.getProperty("deviceHost", "emulation");

            return switch (deviceHost) {
                case "browserstack" -> new BrowserstackDriver();
                case "emulation" -> new EmulationDriver();
                default -> throw new IllegalArgumentException(
                        "Unknown deviceHost: " + deviceHost);
            };
        }
}
