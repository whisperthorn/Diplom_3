package site.stellarburgers.model.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PasswordResetPage {
    private static final By LOGIN_BUTTON = By.xpath(".//a[text()='Войти']");

    private WebDriver driver;

    public PasswordResetPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку Войти в аккаунт")
    public void clickLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
    }
}
