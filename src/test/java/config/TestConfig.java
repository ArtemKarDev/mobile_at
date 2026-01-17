package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:config/${deviceHost}.properties",
        "classpath:config/android.properties"
})
public interface TestConfig extends Config {

        @Key("platformName")
        String platformName();

        @Key("browserstack.user")
        String browserstackUser();

        @Key("browserstack.key")
        String browserstackKey();

        @Key("app")
        String app();

        @Key("appActivity")
        String appActivity();

        @Key("appPackage")
        String appPackage();

        @Key("appium.automationName")
        String appiumAutomationName();

        @Key("appiumUrl")
        String appiumUrl();

        @Key("deviceName")
        @DefaultValue("Samsung Galaxy S22 Ultra")
        String deviceName();

        @Key("platformVersion")
        @DefaultValue("12.0")
        String platformVersion();

        @Key("project")
        String project();

        @Key("build")
        String buildName();

        @Key("name")
        String testName();
}
