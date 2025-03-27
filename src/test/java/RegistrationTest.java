import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.model.page.objects.LoginPage;
import site.stellarburgers.model.page.objects.MainPage;
import site.stellarburgers.model.page.objects.PageEndpoints;
import site.stellarburgers.model.page.objects.RegistrationPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest{

    @Test
    @DisplayName("Регистрация с валидными данными")
    @Description("Проверяем успешную регистрацию используя валидные данные в обязательных полях")
    public void testRegistrationSuccess(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage regPage = new RegistrationPage(driver);

        // Открываем главную страницу
        driver.get(PageEndpoints.MAIN_PAGE_URL);

        // Совершаем шаги для перехода с главной страницы на страницу регистрации
        mainPage.openRegistrationForm();

        // Заполняем форму регистрации
        regPage.inputValidCredentials(credentials);

        // Нажимаем на кнопку Зарегистрировать
        regPage.clickRegisterButton();

        // Ждем обновления URL
        String actual = loginPage.getUrl();

        // Проверяем что мы на странице авторизации
        assertEquals("Должен быть URL страницы авторизации", PageEndpoints.LOGIN_PAGE_URL, actual);
    }

    @Test
    @DisplayName("Ошибка при вводе пароля недостаточной длины")
    @Description("Проверяем ошибку при вводе в поле пароль значения длиной менее 6 символов")
    public void testRegistrationShortPassword(){
        RegistrationPage regPage = new RegistrationPage(driver);

        // Открываем страницу регистрации и создаем объект страницы
        driver.get(PageEndpoints.REGISTER_PAGE_URL);

        // Вводим в поле пароля значение недостаточной длины и нажимаем на кнопку Зарегистрировать, чтобы проверить ошибку
        regPage.inputInvalidPassword(dataGen.getShortPassword());

        // Проверяем наличие ошибки
        assertTrue("Должно быть сообщение об ошибке", regPage.isPasswordErrorVisible());
    }
}
