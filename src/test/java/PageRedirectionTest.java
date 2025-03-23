import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.model.page.objects.AccountPage;
import site.stellarburgers.model.page.objects.LoginPage;
import site.stellarburgers.model.page.objects.MainPage;
import site.stellarburgers.model.page.objects.PageEndpoints;

import static org.junit.Assert.assertEquals;

public class PageRedirectionTest extends BaseTest{
    MainPage mainPage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Before
    public void createAccount(){
        api.createAccount(credentials);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    @DisplayName("Клик по кнопке личного кабинета на главной странице")
    @Description("Проверяем переход в личный кабинет через кнопку на главной странице")
    public void testClickAccountButton(){
        // Вводим данные и авторизируемся
        driver.get(PageEndpoints.LOGIN_PAGE_URL);
        loginPage.inputValidCredentials(credentials);
        loginPage.clickLoginButton();

        //Открываем личный кабинет
        mainPage.clickAccountButton();

        // Ждем обновления URL
        String actual = accountPage.getUrl();

        // Проверяем что мы на странице авторизации
        assertEquals("Должен быть URL личного кабинета", PageEndpoints.ACCOUNT_PAGE_URL, actual);
    }

    @Test
    @DisplayName("Клик по Лого в личном аккаунте")
    @Description("Проверяем переход на главную страницу через Лого в личном кабинете")
    public void testClickLogoAccount(){
        // Вводим данные и авторизируемся
        driver.get(PageEndpoints.LOGIN_PAGE_URL);
        loginPage.inputValidCredentials(credentials);
        loginPage.clickLoginButton();

        //Открываем личный кабинет
        mainPage.clickAccountButton();

        //Кликаем по Лого
        accountPage.clickLogoButton();

        // Ждем обновления URL
        String actual =  mainPage.getUrl();

        // Проверяем что мы на странице авторизации
        assertEquals("Должен быть URL главной страницы", PageEndpoints.MAIN_PAGE_URL, actual);
    }

    @Test
    @DisplayName("Клик по Конструктору в личном кабинете")
    @Description("Проверяем переход на главную страницу через кнопку Конструктор в личном кабинете")
    public void testClickConstructorAccount(){
        // Вводим данные и авторизируемся
        driver.get(PageEndpoints.LOGIN_PAGE_URL);
        loginPage.inputValidCredentials(credentials);
        loginPage.clickLoginButton();

        //Открываем личный кабинет
        mainPage.clickAccountButton();

        //Кликаем по Конструктору
        accountPage.clickConstructorButton();

        // Ждем обновления URL
        String actual =  mainPage.getUrl();

        // Проверяем что мы на странице авторизации
        assertEquals("Должен быть URL главной страницы", PageEndpoints.MAIN_PAGE_URL, actual);
    }
}
