package site.stellarburgers.model.util;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class DataFaker {

    @Step("Создаем данные для аккаунта")
    public CreateAccountPojo getCredentials()
    {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = faker.number().digits(4)+faker.internet().emailAddress();
        String password = faker.internet().password(11,12);
        CreateAccountPojo credentials = new CreateAccountPojo(email, password, name);
        return credentials;
    }

    @Step("Генерируем невалидный короткий пароль")
    public String getShortPassword() {
        Faker faker = new Faker();
        return faker.internet().password(1, 5);
    }
}
