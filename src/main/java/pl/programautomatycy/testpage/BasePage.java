package pl.programautomatycy.testpage;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void clickElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isElementVisible(WebElement element) {
        try {
            waitForElementToBeVisible(element);
        } catch (TimeoutException ignore) {
            return false;
        }
        return true;
    }

    protected boolean isElementNotEmpty(WebElement element) {
        try {
            wait.until((ExpectedCondition<Boolean>) driver -> {
                String text = element.getAttribute("value");
                return text != null && !text.trim().isEmpty();
            });
        } catch (TimeoutException ignore) {
            return false;
        }
        return true;
    }

    private void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
