package org.example.afishaappiumtest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Capability {
    private static final String APP_PATH = "C:\\Users\\Zero\\Desktop\\Workers\\Manual\\LD\\Афиша_ кино, театр, концерты_7.0.5_APKPure.apk";
    private static final String DEVICE_NAME = "emulator-5554";
    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:app", APP_PATH);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", DEVICE_NAME);
        capabilities.setCapability("appium:automationName", "uiAutomator2");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);

        return capabilities;
    }

    public static URL getAppiumServerURL() throws MalformedURLException {
        return new URL(APPIUM_SERVER_URL);
    }

    public static AndroidDriver initializeDriver() throws MalformedURLException {
        return new AndroidDriver(getAppiumServerURL(), getCapabilities());
    }
}