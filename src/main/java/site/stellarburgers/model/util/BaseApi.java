package site.stellarburgers.model.util;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseApi {
    protected static final String ST_BURGERS_BASE_URL = "https://stellarburgers.nomoreparties.site";
    protected static final String ST_BURGERS_LOGIN = "/api/auth/login";
    protected static final String ST_BURGERS_REGISTER = "/api/auth/register";
    protected static final String ST_BURGERS_USER = "/api/auth/user";

    @Step("Отправляем DELETE запрос на {endpoint} c токеном авторизации")
    public Response sendDeleteRequest(String endpoint, String bearerToken){
        RestAssured.baseURI = ST_BURGERS_BASE_URL;
        return given()
                .header("Authorization", bearerToken)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    @Step("Отправляем POST запрос на {endpoint}")
    public Response sendPostRequest(String endpoint, Object jsonBody){
        RestAssured.baseURI = ST_BURGERS_BASE_URL;
        return given()
                .header("Content-type", "application/json")
                .body(jsonBody)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    @Step("Регистрируем новый аккаунт")
    public void createAccount(CreateAccountPojo credentials){
        // Отправляем POST запрос на регистрацию
        sendPostRequest(ST_BURGERS_REGISTER, credentials);
    }

    private String logIn(CreateAccountPojo authCredentials){
        //Отправляем запрос на авторизацию и получаем токен
        return sendPostRequest(ST_BURGERS_LOGIN, authCredentials).jsonPath().getString("accessToken");
    }


    public void deleteAccount(CreateAccountPojo credentials){
        String bearerToken = logIn(credentials)+"";
        sendDeleteRequest(ST_BURGERS_USER, bearerToken);
    }
}