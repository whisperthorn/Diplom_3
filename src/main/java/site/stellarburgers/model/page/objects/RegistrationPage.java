package site.stellarburgers.model.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.stellarburgers.model.Util.CreateAccountPojo;
import java.time.Duration;

public class RegistrationPage {
    private static final By REGISTER_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By EMAIL_FIELD = By.xpath(".//label[text()='Email']/parent::*/input");
    private static final By NAME_FIELD = By.xpath(".//label[text()='Имя']/parent::*/input");
    private static final By PASSWORD_FIELD = By.xpath(".//label[text()='Пароль']/parent::*/input");
    private static final By PASSWORD_ERROR_MESSAGE = By.xpath(".//p[text()='Некорректный пароль']");
    private static final By LOGIN_BUTTON = By.xpath(".//a[text()='Войти']");

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполняем поля формы регистрации валидными данными")
    public void inputValidCredentials(CreateAccountPojo credentials){
        fillName(credentials.getName());
        fillEmail(credentials.getEmail());
        fillPassword(credentials.getPassword());
    }

    @Step("Заполняем поле пароля невалидными данными в форме регистрации ")
    public void inputInvalidPassword(String shortPassword){
        fillPassword(shortPassword);
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

    public void fillName(String name){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(NAME_FIELD),
                        ExpectedConditions.elementToBeClickable(NAME_FIELD)));
        driver.findElement(NAME_FIELD).click();
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    @Step("Завершаем регистрацию")
    public void clickRegisterButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON),
                        ExpectedConditions.elementToBeClickable(REGISTER_BUTTON)));
        driver.findElement(REGISTER_BUTTON).click();
    }

    @Step("Проверяем наличие ошибки поля пароль")
    public boolean isPasswordErrorVisible(){
        clickRegisterButton();
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_ERROR_MESSAGE));
            driver.findElement(PASSWORD_ERROR_MESSAGE);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Нажимаем на кнопку Войти в аккаунт")
    public void clickLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
    }
}
