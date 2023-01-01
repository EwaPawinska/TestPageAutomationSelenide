import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("disable-infobars");
        Configuration.timeout = 5000L;
        Configuration.pollingInterval = 500L;
        Configuration.headless = false;
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
