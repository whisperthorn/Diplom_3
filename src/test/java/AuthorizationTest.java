import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.model.page.objects.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AuthorizationTest extends BaseTest{
    MainPage mainPage;
    LoginPage loginPage;

    @Before
    public void createAccount(){
        api.createAccount(credentials);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Авторизация через кнопку «Войти в аккаунт» на главной странице")
    @Description("Проверяем успешную авторизацию через кнопку «Войти в аккаунт» на главной странице")
    public void testLoginMainPage(){
        // Открываем главную страницу
        driver.get(PageEndpoints.MAIN_PAGE_URL);

        // Открываем страницу авторизации через кнопку "Войти в аккаунт"
        mainPage.clickLoginButton();

        // Вводим данные и авторизируемся
        loginPage.inputValidCredentials(credentials);
        loginPage.clickLoginButton();

        // Проверяем доступность элемента после авторизации
        Boolean actual = mainPage.isMakeOrderVisible();
        assertTrue("Кнопка 'Оформить заказ' должна быть доступна после авторизации", actual);
    }

    @Test
    @DisplayName("Авторизация через кнопку «Личный кабинет» на главной странице")
    @Description("Проверяем успешную авторизацию через кнопку «Личный кабинет» на главной странице")
    public void testLoginAccountPage(){
        // Открываем главную страницу
        driver.get(PageEndpoints.MAIN_PAGE_URL);

        // Открываем страницу авторизации через кнопку "Войти в аккаунт"
        mainPage.clickAccountButton();

        // Вводим данные и авторизируемся
        loginPage.inputValidCredentials(credentials);
        loginPage.clickLoginButton();

        // Проверяем доступность элемента после авторизации
        Boolean actual = mainPage.isMakeOrderVisible();
        assertTrue("Кнопка 'Оформить заказ' должна быть доступна после авторизации", actual);
    }

    @Test
    @DisplayName("Авторизация через кнопку «Войти» в форме регистрации")
    @Description("Проверяем успешную авторизацию через кнопку «Войти» в форме регистрации")
    public void testLoginRegistrationPage(){
        RegistrationPage regPage = new RegistrationPage(driver);

        //Открываем страницу регистрации
        driver.get(PageEndpoints.REGISTER_PAGE_URL);

        // Открываем страницу авторизации через кнопку "Войти"
        regPage.clickLoginButton();

        // Вводим данные и авторизируемся
        loginPage.inputValidCredentials(credentials);
        loginPage.clickLoginButton();

        // Проверяем доступность элемента после авторизации
        Boolean actual = mainPage.isMakeOrderVisible();
        assertTrue("Кнопка 'Оформить заказ' должна быть доступна после авторизации", actual);
    }

    @Test
    @DisplayName("Авторизация через кнопку «Войти» в форме восстановления пароля")
    @Description("Проверяем успешную авторизацию через кнопку «Войти» в форме восстановления пароля")
    public void testLoginResetPasswordPage(){
        PasswordResetPage resetPassPage = new PasswordResetPage(driver);

        //Открываем страницу сброса пароля
        driver.get(PageEndpoints.RESET_PASSWORD_URL);

        // Открываем страницу авторизации через кнопку "Войти"
        resetPassPage.clickLoginButton();

        // Вводим данные и авторизируемся
        loginPage.inputValidCredentials(credentials);
        loginPage.clickLoginButton();

        // Проверяем доступность элемента после авторизации
        Boolean actual = mainPage.isMakeOrderVisible();
        assertTrue("Кнопка 'Оформить заказ' должна быть доступна после авторизации", actual);
    }

    @Test
    @DisplayName("Выход по кнопке 'Выйти' в личном кабинете")
    @Description("Проверяем успешную авторизацию через кнопку «Войти» в форме восстановления пароля")
    public void testLogoutAccountPage(){
        AccountPage accountPage = new AccountPage(driver);

        // Вводим данные и авторизируемся
        driver.get(PageEndpoints.LOGIN_PAGE_URL);
        loginPage.inputValidCredentials(credentials);
        loginPage.clickLoginButton();

        //Открываем личный кабинет
        mainPage.clickAccountButton();

        //Выходим через кнопку "Выйти" в личном кабинете
        accountPage.clickLogOutButton();

        // Ждем обновления URL
        String actual = loginPage.getUrl();

        // Проверяем что мы на странице авторизации
        assertEquals("Должен быть URL страницы авторизации", PageEndpoints.LOGIN_PAGE_URL, actual);
    }
}
