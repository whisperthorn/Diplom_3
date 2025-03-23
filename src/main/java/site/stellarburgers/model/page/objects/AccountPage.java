package site.stellarburgers.model.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountPage {
    private static final By LOGOUT_BUTTON = By.xpath(".//button[text()='Выход']");
    private static final By LOGO_BUTTON = By.className("AppHeader_header__logo__2D0X2");
    private static final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку 'Выход' в личном кабинете")
    public void clickLogOutButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON));
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step("Нажимаем на Лого в личном кабинете")
    public void clickLogoButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(LOGO_BUTTON));
        driver.findElement(LOGO_BUTTON).click();
    }

    @Step("Нажимаем на кнопку Конструктор в личном кабинете")
    public void clickConstructorButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(CONSTRUCTOR_BUTTON));
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    @Step("Ждем и получаем адрес страницы")
    public String getUrl(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.urlMatches(PageEndpoints.ACCOUNT_PAGE_URL));
        return driver.getCurrentUrl();
    }

}
