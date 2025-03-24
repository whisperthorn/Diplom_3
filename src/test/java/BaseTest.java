import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import site.stellarburgers.model.util.BaseApi;
import site.stellarburgers.model.util.CreateAccountPojo;
import site.stellarburgers.model.util.DataFaker;
import site.stellarburgers.model.webdriver.WebDriverFactory;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected CreateAccountPojo credentials;
    protected BaseApi api;
    protected DataFaker dataGen;

    @Before
    public void setUp(){
        webDriverSetUp();
        api = new BaseApi();
        dataGen = new DataFaker();
        credentials = dataGen.getCredentials();
    }

    @After
    public void tearDown(){
        driver.quit();
        api.deleteAccount(credentials);
    }

    public void webDriverSetUp(){
        String browser = System.getProperty("browser","chrome");
        driver = WebDriverFactory.createWebDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}