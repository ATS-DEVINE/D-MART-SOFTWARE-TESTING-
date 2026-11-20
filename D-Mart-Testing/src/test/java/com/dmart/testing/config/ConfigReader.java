package com.dmart.testing.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(CONFIG_PATH);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getAppUrl() {
        return properties.getProperty("app.url");
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("app.timeout"));
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    public static boolean maximizeWindow() {
        return Boolean.parseBoolean(properties.getProperty("window.maximize"));
    }

    public static String getTestUserEmail() {
        return properties.getProperty("test.user.email");
    }

    public static String getTestUserPassword() {
        return properties.getProperty("test.user.password");
    }

    public static String getTestUserName() {
        return properties.getProperty("test.user.name");
    }

    public static String getTestSellerEmail() {
        return properties.getProperty("test.seller.email");
    }

    public static String getTestSellerPassword() {
        return properties.getProperty("test.seller.password");
    }

    public static String getTestAdminEmail() {
        return properties.getProperty("test.admin.email");
    }

    public static String getTestAdminPassword() {
        return properties.getProperty("test.admin.password");
    }

    public static boolean takeScreenshotOnFailure() {
        return Boolean.parseBoolean(properties.getProperty("screenshot.on.failure"));
    }

    public static String getScreenshotPath() {
        return properties.getProperty("screenshot.path");
    }
}
