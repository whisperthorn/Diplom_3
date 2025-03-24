package site.stellarburgers.model.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.stellarburgers.model.util.CreateAccountPojo;
import java.time.Duration;

public class LoginPage {
    protected static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    protected static final By REGISTER_BUTTON = By.xpath(".//*[text()='Зарегистрироваться']");
    protected static final By EMAIL_FIELD = By.xpath(".//label[text()='Email']/parent::*/input");
    protected static final By PASSWORD_FIELD = By.xpath(".//label[text()='Пароль']/parent::*/input");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполняем поля формы регистрации валидными данными")
    public void inputValidCredentials(CreateAccountPojo credentials){
        fillEmail(credentials.getEmail());
        fillPassword(credentials.getPassword());
    }

    public void fillEmail(String email){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD),
                        ExpectedConditions.elementToBeClickable(EMAIL_FIELD)));
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    public void fillPassword(String password){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD),
                        ExpectedConditions.elementToBeClickable(PASSWORD_FIELD)));
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Завершаем авторизацию")
    public void clickLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON),
                        ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)));
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Ждем и получаем адрес страницы")
    public String getUrl(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.urlMatches(PageEndpoints.LOGIN_PAGE_URL));
        return driver.getCurrentUrl();
    }
}