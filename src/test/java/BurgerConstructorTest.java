import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.model.page.objects.MainPage;
import site.stellarburgers.model.page.objects.PageEndpoints;

import static org.junit.Assert.assertTrue;

public class BurgerConstructorTest extends BaseTest{
    MainPage mainPage;
    private final String bun = "Булки";
    private final String sauce = "Соусы";
    private final String filling = "Начинки";

    @Override
    @Before
    public void setUp() {
        webDriverSetUp();
        mainPage = new MainPage(driver);
        driver.get(PageEndpoints.MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Переход к разделу Булки в конструкторе бургеров")
    @Description("Проверяем успешный переход в раздел Булки при нажатии на соответствующую кнопку в конструкторе бургеров")
    public void testConstructorBunSection() {
        // Для проверки перехода на булки надо выбрать другой раздел
        mainPage.clickFillingSection();

        // Выбираем раздел Булки
        mainPage.clickBunSection();

        // Проверяем, что раздел Булки активен
        boolean actual = mainPage.isBunSectionActive();
        assertTrue(String.format("Кнопка раздела %s должна быть активна", bun), actual);

        // Проверяем, что раздел видно на экране
        assertTrue(String.format("Раздел %s должно быть видно на экране", bun), mainPage.isBunSectionInViewport());
    }

    @Test
    @DisplayName("Переход к разделу Соусы в конструкторе бургеров")
    @Description("Проверяем успешный переход в раздел Соусы при нажатии на соответствующую кнопку в конструкторе бургеров")
    public void testConstructorSauceSection(){
        // Выбираем раздел Соусы
        mainPage.clickSauceSection();

        // Проверяем, что раздел Соусы активен
        boolean actual = mainPage.isSauceSectionActive();
        assertTrue(String.format("Кнопка раздела %s должна быть активна", sauce), actual);

        // Проверяем, что раздел видно на экране
        assertTrue(String.format("Раздел %s должно быть видно на экране", sauce), mainPage.isSauceSectionInViewport());
    }

    @Test
    @DisplayName("Переход к разделу Начинки в конструкторе бургеров")
    @Description("Проверяем успешный переход в раздел Начинки при нажатии на соответствующую кнопку в конструкторе бургеров")
    public void testConstructorFillingSection(){
        // Выбираем раздел Начинки
        mainPage.clickFillingSection();

        // Проверяем, что раздел Начинки активен
        boolean actual = mainPage.isFillingSectionActive();
        assertTrue(String.format("Кнопка раздела %s должна быть активна", filling), actual);

        // Проверяем, что раздел видно на экране
        assertTrue(String.format("Раздел %s должно быть видно на экране", filling), mainPage.isFillingSectionInViewport());
    }

    @Override
    @After
    public void tearDown(){
        driver.quit();
    }
}