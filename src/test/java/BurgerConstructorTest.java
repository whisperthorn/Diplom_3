import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.model.page.objects.MainPage;
import site.stellarburgers.model.page.objects.PageEndpoints;
import site.stellarburgers.model.webdriver.WebDriverFactory;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class BurgerConstructorTest extends BaseTest{
    MainPage mainPage;
    private final String bun = "Булки";
    private final String sauce = "Соусы";
    private final String filling = "Начинки";

    @Override
    @Before
    public void setUp() {
        String browser = System.getProperty("browser","chrome");
        driver = WebDriverFactory.createWebDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        mainPage = new MainPage(driver);
        driver.get(PageEndpoints.MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Переход к разделу Булки в конструкторе бургеров")
    @Description("Проверяем успешный переход в раздел Булки при нажатии на соответствующую кнопку в конструкторе бургеров")
    public void testConstructorBunSection(){
        // Для проверки перехода на булки надо выбрать другой раздел
        mainPage.clickSauceSection();

        // Выбираем раздел Булки
        mainPage.clickBunSection();

        // Проверяем, что раздел Булки активен
        boolean actual = mainPage.isSectionActive(bun);
        assertTrue(String.format("Раздел %S должен быть активен", bun), actual);
    }

    @Test
    @DisplayName("Переход к разделу Соусы в конструкторе бургеров")
    @Description("Проверяем успешный переход в раздел Соусы при нажатии на соответствующую кнопку в конструкторе бургеров")
    public void testConstructorSauceSection(){
        // Выбираем раздел Соусы
        mainPage.clickSauceSection();

        // Проверяем, что раздел Соусы активен
        boolean actual = mainPage.isSectionActive(sauce);
        assertTrue(String.format("Раздел %S должен быть активен", sauce), actual);
    }

    @Test
    @DisplayName("Переход к разделу Начинки в конструкторе бургеров")
    @Description("Проверяем успешный переход в раздел Начинки при нажатии на соответствующую кнопку в конструкторе бургеров")
    public void testConstructorFillingSection(){
        // Выбираем раздел Начинки
        mainPage.clickFillingSection();

        // Проверяем, что раздел Начинки активен
        boolean actual = mainPage.isSectionActive(filling);
        assertTrue(String.format("Раздел %S должен быть активен", filling), actual);
    }

    @Override
    @After
    public void tearDown(){
        driver.quit();
    }
}