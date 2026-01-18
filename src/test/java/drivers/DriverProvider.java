package drivers;

import com.codeborne.selenide.WebDriverProvider;

public class DriverProvider {
        public static String getDriver() {

            String deviceHost =
                    System.getProperty("deviceHost", "emulation");

            return switch (deviceHost) {
                case "browserstack" -> BrowserstackDriver.class.getName();
                case "emulation" -> EmulationDriver.class.getName();
                default -> throw new IllegalArgumentException(
                        "Unknown deviceHost: " + deviceHost);
            };
        }
}
