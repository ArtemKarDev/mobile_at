package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    INSTANCE;

    private final TestConfig config;

    ConfigReader() {
        try {
            this.config = ConfigFactory.create(TestConfig.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config: " + e.getMessage(), e);
        }
    }

    public TestConfig getConfig() {
        return config;
    }

}
