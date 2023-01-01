import org.junit.Before;
import org.junit.Test;
import pagetoautomate.HomePage;
import pagetoautomate.homepage.FirstForm;

import static com.codeborne.selenide.Selenide.open;
import static pagetoautomate.homepage.FirstForm.AcceptPolicy.YES;
import static pagetoautomate.homepage.FirstForm.Browser.*;
import static pagetoautomate.homepage.FirstForm.FavoriteDayOfTheWeekDropdown.FRIDAY;
import static pagetoautomate.homepage.FirstForm.OptionRadio.OPTION_3;

public class PageToAutomateTest extends TestBase {

    private final HomePage homePage = new HomePage();

    @Before
    public void openHomePage() {
        open("https://programautomatycy.pl/test-page/");
    }

    @Test
    public void displayHomePage() {
        homePage.verifyAllWebElementsAreDisplayed();
    }

    @Test
    public void fillFirstFormWithCorrectData() {
        FirstForm firstForm = homePage.getFirstForm();

        firstForm.getFirstNameInput().setValue("Ewa");
        firstForm.getSecondNameInput().setValue("nie ma");
        firstForm.getLastNameInput().setValue("Nowakowska");
        firstForm.selectRadioOption(OPTION_3);
        firstForm.selectFavoriteDayOfTheWeek(FRIDAY);
        firstForm.selectManyBrowsers(CHROME, FIREFOX, EDGE, OPERA);
        firstForm.getDescriptionTextarea().setValue("opis");
        firstForm.acceptPolicy(YES);
    }
}
