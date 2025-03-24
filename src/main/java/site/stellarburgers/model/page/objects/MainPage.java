package site.stellarburgers.model.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static site.stellarburgers.model.page.objects.LoginPage.REGISTER_BUTTON;

public class MainPage {
    protected static final By ACCOUNT_BUTTON = By.xpath
            (".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    protected static final By LOGIN_BUTTON =  By.xpath(".//button[text()='Войти в аккаунт']");
    protected static final By MAKE_ORDER_BUTTON =  By.xpath(".//button[text()='Оформить заказ']");
    private static final By BUNS_SECTION = By.xpath(".//span[text()='Булки']/parent::div");
    private static final By SAUCE_SECTION = By.xpath(".//span[text()='Соусы']/parent::div");
    private static final By FILLING_SECTION = By.xpath(".//span[text()='Начинки']/parent::div");
    private static final String ACTIVE_SECTION = "tab_tab_type_current__2BEPc";
    private static final By BUNS_SECTION_HEADER = By.xpath
            (".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']");
    private static final By SAUCE_SECTION_HEADER = By.xpath
            (".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']");
    private static final By FILLING_SECTION_HEADER = By.xpath
            (".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']");

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

    @Step("Проверяем активен ли раздел Булки")
    public boolean isBunSectionActive(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUNS_SECTION));
        WebElement activeElement = driver.findElement(BUNS_SECTION);

        //Ждем пока у кнопки раздела появится нужный атрибут, если не появится то тест упадет
        wait.until(driver -> activeElement.getAttribute("class").contains(ACTIVE_SECTION));
        return true;
    }

    @Step("Проверяем активен ли раздел Соусы")
    public boolean isSauceSectionActive(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAUCE_SECTION));
        WebElement activeElement = driver.findElement(SAUCE_SECTION);

        //Ждем пока у кнопки раздела появится нужный атрибут, если не появится то тест упадет
        wait.until(driver -> activeElement.getAttribute("class").contains(ACTIVE_SECTION));
        return true;
    }

    @Step("Проверяем активен ли раздел Начинки")
    public boolean isFillingSectionActive(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FILLING_SECTION));
        WebElement activeElement = driver.findElement(FILLING_SECTION);

        //Ждем пока у кнопки раздела появится нужный атрибут, если не появится то тест упадет
        wait.until(driver -> activeElement.getAttribute("class").contains(ACTIVE_SECTION));
        return true;
    }

    @Step("Проверяем, что раздел Булки видно на экране в конструкторе")
    public boolean isBunSectionInViewport(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(BUNS_SECTION_HEADER));
        WebElement activeElement = driver.findElement(BUNS_SECTION_HEADER);
        return isElementInViewport(activeElement);
    }

    @Step("Проверяем, что раздел Соусы видно на экране в конструкторе")
    public boolean isSauceSectionInViewport(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCE_SECTION_HEADER));
        WebElement activeElement = driver.findElement(SAUCE_SECTION_HEADER);
        return isElementInViewport(activeElement);
    }

    @Step("Проверяем, что раздел Начинки видно на экране в конструкторе")
    public boolean isFillingSectionInViewport(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(FILLING_SECTION_HEADER));
        WebElement activeElement = driver.findElement(FILLING_SECTION_HEADER);
        return isElementInViewport(activeElement);
    }

    public boolean isElementInViewport(WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(
                        driver -> {
                            Rectangle rect = element.getRect();
                            Dimension windowSize = driver.manage().window().getSize();

                            return rect.getX() >= 0
                                    && rect.getY() >= 0
                                    && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                    && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                        });
    }
}
