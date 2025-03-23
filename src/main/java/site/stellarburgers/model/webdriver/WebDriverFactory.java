package site.stellarburgers.model.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver createWebDriver(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\chromedriver.exe");
                return new ChromeDriver();

            case "yandex":
                System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\yandexdriver.exe");
                return new ChromeDriver();

            default:
                throw new IllegalArgumentException("Неподдерживаемый браузер:" + browser);
            }
        }
}