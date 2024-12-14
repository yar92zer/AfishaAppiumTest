package org.example.afishaappiumtest;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.slf4j.Logger;

public class AllureLogger {
    private final Logger logger;
    private final AndroidDriver driver;

    public AllureLogger(Logger logger, AndroidDriver driver) {
        this.logger = logger;
        this.driver = driver;
    }

    @Step("{logText}")
    public void into(String logText) {
        logger.info(logText);
    }

    @Step("{logText}")
    public void infoWithScreenshot(String logText) {
        logger.info(logText);
        AllureAttachmentsManager.screenshot(driver);
    }
}
