package org.example.afishaappiumtest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class IntoScreen {
    private final allureLogger LOG;
    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    @AndroidFindBy(id = "fragOnboardingSkipBtn")
    private WebElement skipButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"ru.afisha.android:id/fragOnboardinSubmitBtn\"]")
    private WebElement submitButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
    private WebElement yourCity;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement yesCityButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
    private WebElement noCityButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Афиша\"]")
    private WebElement afishaButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Выбор города\"]")
    private WebElement citySelectionButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"ru.afisha.android:id/viewSearchText\"]")
    private WebElement citySearch;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"ru.afisha.android:id/fragCitySelectionCitiesRv\"]/android.widget.LinearLayout[1]")
    private WebElement moscowButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"ru.afisha.android:id/itemCitySelectionName\" and @text=\"Санкт-Петербург\"]")
    private WebElement stPetersburgButton;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"ru.afisha.android:id/fragCitySelectionCitiesRv\"]/android.widget.LinearLayout[3]")
    private WebElement abakanButton;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"ru.afisha.android:id/fragCitySelectionCitiesRv\"]/android.widget.LinearLayout[4]")
    private WebElement azovButton;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"ru.afisha.android:id/fragCitySelectionCitiesRv\"]/android.widget.LinearLayout[6]")
    private WebElement anapaButton;

    public IntoScreen(AndroidDriver driver) {
        this.driver = driver;
        this.LOG = new allureLogger(LoggerFactory.getLogger(IntoScreen.class), driver);
        this.wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean checkSubmitButton() {
        LOG.into("Проверка доступности кнопки 'пропуска гео'");
        waitForElementVisible(submitButton);
        return submitButton.isEnabled();
    }

    public boolean checkSkipButton() {
        LOG.into("Проверка доступности кнопки 'Включить геолокацию'");
        waitForElementVisible(skipButton);
        return skipButton.isEnabled();
    }

    public boolean submitButtonTransition() {
        LOG.into("Переход на страницу Ваш город - Москва?");
        waitForElementClickable(skipButton);
        skipButton.click();
        waitForElementVisible(yourCity);
        return yourCity.isEnabled();
    }

    public boolean yesCityButtonTransition() {
        LOG.into("Подтверждение выбора города");
        waitForElementVisible(skipButton);
        skipButton.click();
        waitForElementVisible(yourCity);
        waitForElementClickable(yesCityButton);
        yesCityButton.click();
        waitForElementVisible(afishaButton);
        return afishaButton.isDisplayed();
    }

    public boolean selectDifferentCity() {
        LOG.into("Выбор другого города");
        waitForElementVisible(skipButton);
        skipButton.click();
        waitForElementVisible(yourCity);
        waitForElementClickable(noCityButton);
        noCityButton.click();
        waitForElementVisible(citySelectionButton);
        return citySelectionButton.isDisplayed();
    }

    public boolean citySearchWork () {
        LOG.into("Поиск города: ");
        waitForElementClickable(citySearch);
        citySearch.click();
        return true;
    }

    public boolean selectMoscow() {
        LOG.into("Выбор города Москва");
        waitForElementClickable(moscowButton);
        moscowButton.click();
        return true;
    }

    public boolean selectSaintPetersburg() {
        LOG.into("Выбор города Санкт-Петербург");
        waitForElementClickable(stPetersburgButton);
        stPetersburgButton.click();
        return true;
    }

    public boolean selectAbakan() {
        LOG.into("Выбор города Абакан");
        waitForElementClickable(abakanButton);
        abakanButton.click();
        return true;
    }

    public boolean selectAzov() {
        LOG.into("Выбор города Азов");
        waitForElementClickable(azovButton);
        azovButton.click();
        return true;
    }

    public boolean selectAnapa() {
        LOG.into("Выбор города Анапа");
        waitForElementClickable(anapaButton);
        anapaButton.click();
        return true;
    }
}