package org.example.afishaappiumtest;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class allureAttachmentsManager {@Attachment(value = "Screenshot", type = "image/png")
public static byte[] screenshot(AndroidDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
}
}
