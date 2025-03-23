package site.stellarburgers.model.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static site.stellarburgers.model.page.objects.LoginPage.REGISTER_BUTTON;

public class MainPage {
    protected static final By ACCOUNT_BUTTON = By.xpath
            (".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    protected static final By LOGIN_BUTTON =  By.xpath(".//button[text()='Войти в аккаунт']");
    protected static final By MAKE_ORDER_BUTTON =  By.xpath(".//button[text()='Оформить заказ']");
    private static final By BUNS_SECTION = By.xpath(".//span[text()='Булки']");
    private static final By SAUCE_SECTION = By.xpath(".//span[text()='Соусы']");
    private static final By FILLING_SECTION = By.xpath(".//span[text()='Начинки']");
    private static final By ACTIVE_SECTION = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRegistrationForm(){
        clickAccountButton();
        clickRegisterButton();
    }

    @Step("Нажимаем на личный кабинет")
    public void clickAccountButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(ACCOUNT_BUTTON));
        driver.findElement(ACCOUNT_BUTTON).click();
    }

    @Step("Нажимаем на кнопку Войти в аккаунт")
    public void clickLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Нажимаем на кнопку зарегистрироваться")
    public void clickRegisterButton(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(REGISTER_BUTTON));
        driver.findElement(REGISTER_BUTTON).click();
    }

    @Step("Ждем и получаем адрес страницы")
    public String getUrl(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.urlMatches(PageEndpoints.MAIN_PAGE_URL));
        return driver.getCurrentUrl();
    }

    @Step("Ждем появления кнопки Оформить заказ")
    public boolean isMakeOrderVisible(){
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOfElementLocated(MAKE_ORDER_BUTTON));
            return driver.findElement(MAKE_ORDER_BUTTON).isDisplayed();
    }

    @Step("Кликаем на раздел Булки")
    public void clickBunSection(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(BUNS_SECTION));
        driver.findElement(BUNS_SECTION).click();
    }

    @Step("Кликаем на раздел Соусы")
    public void clickSauceSection(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(SAUCE_SECTION));
        driver.findElement(SAUCE_SECTION).click();
    }

    @Step("Кликаем на раздел Начинки")
    public void clickFillingSection(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(FILLING_SECTION));
        driver.findElement(FILLING_SECTION).click();
    }

    @Step("Проверяем активный раздел")
    public boolean isSectionActive(String sectionName){
        WebElement activeElement = driver.findElement(ACTIVE_SECTION);
        return activeElement.getText().contains(sectionName);
    }
}
