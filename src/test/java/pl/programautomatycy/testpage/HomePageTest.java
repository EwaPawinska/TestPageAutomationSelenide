package pl.programautomatycy.testpage;

import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void enterValidFirstNameAndLastNameTest() {
        homePage
                .verifyFirstFormIsVisible()
                .enterFirstName()
                .verifyFirstNameIsNotEmpty()
                .enterLastName()
                .verifyLastNameIsNotEmpty();
    }
}
