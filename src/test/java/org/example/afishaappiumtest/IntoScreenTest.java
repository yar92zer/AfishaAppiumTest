package org.example.afishaappiumtest;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntoScreenTest {
    private AndroidDriver driver;
    private IntoScreen intoScreen;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = Capability.initializeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        intoScreen = new IntoScreen(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    @DisplayName("Проверка активности кнопки пропуска гео")
    public void checkGeoSkipButtonEnabled() {
        assertTrue(intoScreen.checkSkipButton(), "Нет кнопки пропуска гео");
    }

    @Test
    @Order(2)
    @DisplayName("Проверка активности кнопки Включить геолокацию")
    public void checkEnableGeolocationButton() {
        assertTrue(intoScreen.checkSubmitButton(), "Нет кнопки Включить геолокацию");
    }

    @Test
    @Order(3)
    @DisplayName("Открытие страницы Ваш город - Москва?")
    public void verifyMoscowCityPageTransition() {
        assertTrue(intoScreen.submitButtonTransition(), "Страница выбора города не открылась");
    }

    @Test
    @Order(4)
    @DisplayName("Переход в раздел 'Афиша'")
    public void afishaPageTransition() {
        assertTrue(intoScreen.yesCityButtonTransition(), "Раздел афиша не открылсья");
    }

    @Test
    @Order(5)
    @DisplayName("Переход в раздел Выбор города Поиск не активен")
    public void selectCityPageTransition() {
        assertTrue(intoScreen.citySearchWork(), "Поиск не активен");
    }

    @Test
    @Order(6)
    @DisplayName("Проверка выбора города Санкт-Петербург")
    public void verifyCitySelection() {
        assertTrue(intoScreen.selectSaintPetersburg(), "Не удалось выбрать Санкт-Петербург");
    }

    @Test
    @Order(7)
    @DisplayName("Проверка выбора города Москва")
    public void moscoCitySelection() {
        assertTrue(intoScreen.selectMoscow(), "Не удалось выбрать Москва");
    }

    @Test
    @Order(8)
    @DisplayName("Проверка выбора города Абакан")
    public void abakanCitySelection() {
        assertTrue(intoScreen.selectAbakan(), "Не удалось выбрать Абакан");
    }

    @Test
    @Order(9)
    @DisplayName("Проверка выбора города Азов")
    public void azovCitySelection() {
        assertTrue(intoScreen.selectAzov(), "Не удалось выбрать Азов");
    }

    @Test
    @Order(10)
    @DisplayName("Проверка выбора города Aнапа ")
    public void anapaCitySelection() {
        assertTrue(intoScreen.selectAnapa(), "Не удалось выбрать Анапа");
    }
}