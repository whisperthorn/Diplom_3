import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import site.stellarburgers.model.Util.BaseApi;
import site.stellarburgers.model.Util.CreateAccountPojo;
import site.stellarburgers.model.webdriver.WebDriverFactory;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected CreateAccountPojo credentials;
    protected BaseApi api;

    @Before
    public void setUp(){
        String browser = System.getProperty("browser","chrome");
        driver = WebDriverFactory.createWebDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        api = new BaseApi();
        credentials = api.getCredentials();
    }

    @After
    public void tearDown(){
        driver.quit();
        api.deleteAccount(credentials);
    }
}