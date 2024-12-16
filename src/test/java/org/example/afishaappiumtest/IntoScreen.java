package org.example.afishaappiumtest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class IntoScreen extends MyWait {
    private final AllureLogger LOG;
    private final AndroidDriver driver;
    private static final long TIMEOUT_SECONDS = 15;

    @AndroidFindBy(id = "fragOnboardingSkipBtn")
    private WebElement skipButton;

    @AndroidFindBy(id = "ru.afisha.android:id/fragOnboardinSubmitBtn")
    private WebElement submitButton;

    @AndroidFindBy(id = "android:id/message")
    private WebElement yourCity;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement yesCityButton;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement noCityButton;

    @AndroidFindBy(id = "ru.afisha.android:id/main")
    private WebElement afishaButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Выбор города\"]")
    private WebElement citySelectionButton;

    @AndroidFindBy(id = "ru.afisha.android:id/viewSearchText")
    private WebElement citySearch;

    public IntoScreen(AndroidDriver driver) {
        super(driver, TIMEOUT_SECONDS);
        this.driver = driver;
        this.LOG = new AllureLogger(LoggerFactory.getLogger(IntoScreen.class), driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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

    public boolean citySearchWork() {
        LOG.into("Поиск города");
        waitForElementVisible(skipButton);
        skipButton.click();
        waitForElementVisible(yourCity);
        waitForElementClickable(noCityButton);
        noCityButton.click();
        waitForElementVisible(citySelectionButton);
        waitForElementClickable(citySearch);
        citySearch.click();
        return true;
    }

    public boolean selectCityByTextAndOrder(String cityText, int order) {
        LOG.into("Выбор города содержащего текст: " + cityText + " с порядковым номером: " + order);

        waitForElementVisible(skipButton);
        skipButton.click();
        waitForElementVisible(yourCity);
        waitForElementClickable(noCityButton);
        noCityButton.click();
        waitForElementVisible(citySelectionButton);

        String cityXpath = String.format(
                "//androidx.recyclerview.widget.RecyclerView[@resource-id='ru.afisha.android:id/fragCitySelectionCitiesRv']" +
                        "/android.widget.LinearLayout[%d]//android.widget.TextView[contains(@text, '%s')]",
                order, cityText
        );

        try {
            WebElement cityElement = driver.findElement(By.xpath(cityXpath));
            waitForElementClickable(cityElement);
            cityElement.click();
            return true;
        } catch (Exception e) {
            LOG.into("[ОШИБКА] Не удалось найти город с текстом " + cityText + " и порядковым номером " + order);
            return false;
        }
    }

    public boolean selectMoscow() {
        return selectCityByTextAndOrder("Москва", 1);
    }

    public boolean selectSaintPetersburg() {
        return selectCityByTextAndOrder("Санкт-Петербург", 2);
    }

    public boolean selectAbakan() {
        return selectCityByTextAndOrder("Абакан", 3);
    }

    public boolean selectAzov() {
        return selectCityByTextAndOrder("Азов", 4);
    }

    public boolean selectAnapa() {
        return selectCityByTextAndOrder("Анапа", 6);
    }
}