package pl.programautomatycy.testpage;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.testng.Assert.*;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h2[text() = 'FORMULARZ TESTOWY 1']")
    private WebElement firstFormHeader;

    @FindBy(id = "firstname-text")
    private WebElement firstNameInput;

    @FindBy(name = "secondname-text")
    private WebElement lastNameInput;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage verifyFirstFormIsVisible() {
        assertTrue(isElementVisible(firstFormHeader), "Fist form header is not visible");
        assertTrue(isElementVisible(firstNameInput), "Fist name input is not visible");
        assertTrue(isElementVisible(lastNameInput), "Last name input is not visible");
        return this;
    }

    public HomePage enterFirstName() {
        enterText(firstNameInput, "Adam");
        return this;
    }

    public HomePage enterLastName() {
        enterText(lastNameInput, "Kovalski");
        return this;
    }

    public HomePage verifyFirstNameIsNotEmpty() {
        assertTrue(isElementNotEmpty(firstNameInput), "First name is empty");
        return this;
    }

    public HomePage verifyLastNameIsNotEmpty() {
        assertTrue(isElementNotEmpty(lastNameInput), "Last name is empty");
        return this;
    }
}
