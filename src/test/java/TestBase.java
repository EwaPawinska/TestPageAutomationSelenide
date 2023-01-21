import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito", "disable-infobars", "--disable-notifications");
        chromeOptions.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver(chromeOptions);
        Configuration.timeout = 5000L;
        Configuration.pollingInterval = 500L;
        Configuration.headless = false;
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
