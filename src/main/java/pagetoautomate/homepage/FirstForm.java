package pagetoautomate.homepage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.Keys;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class FirstForm {

    private final SelenideElement firstNameInput = $("input[name*='firstname']");
    private final SelenideElement secondNameInput = $("#secondname-text");
    private final SelenideElement lastNameInput = $("#lastname-text");
    private final SelenideElement optionRadio = $("input[name='option']");
    private final SelenideElement dayOfTheWeekDropdown = $("select[name='dayOfTheWeek']");
    private final SelenideElement browserMultiSelect = $("select[id='browser-select-multiple']");
    private final SelenideElement descriptionTextarea = $("textarea#description-text").as("Napisz coś");
    private final SelenideElement acceptPrivacyPolicyRadio = $("input[name='confirmation']");
    private final ElementsCollection groupsCheckboxes = $$("input[name='group[]']");
    private final SelenideElement doNothingButton = $("input#nothing-submit");
    private final SelenideElement errorMessage = $x(".//div[contains(text(), 'Wystąpił problem')]");

    public void selectRadioOption(OptionRadio chosenOption) {
        optionRadio.selectRadio(chosenOption.option);
    }

    public void selectFavoriteDayOfTheWeek(FavoriteDayOfTheWeekDropdown chosenDay) {
        dayOfTheWeekDropdown.selectOptionByValue(chosenDay.dayName);
    }

    public void selectManyBrowsers(Browser... browsers) {
        browserMultiSelect.scrollIntoView(true);

        for (Browser browser : browsers) {
            browserMultiSelect
                    .press(Keys.CONTROL)
                    .selectOptionByValue(browser.browserName);
        }
    }

    public void selectAllCheckboxesWithValue(String value) {
        $$("input[type='checkbox']")
                .asFixedIterable()
                .stream()
                .filter(e -> Objects.requireNonNull(e.getAttribute("value")).equals(value))
                .forEach(SelenideElement::click);
    }

    public void selectGroup(int groupNumber) {
        String groupName = "Grupa " + groupNumber;
        groupsCheckboxes.findBy(Condition.value(groupName)).click();
    }

    public void acceptPolicy(AcceptPolicy acceptPolicy) {
        acceptPrivacyPolicyRadio.selectRadio(acceptPolicy.value);
    }

    @AllArgsConstructor
    public enum OptionRadio {

        OPTION_1("Opcja 1"),
        OPTION_2("Opcja 2"),
        OPTION_3("Opcja 3");

        private final String option;
    }

    @AllArgsConstructor
    public enum Browser {

        CHROME("Google Chrome"),
        SAFARI("Safari"),
        FIREFOX("Mozilla Firefox"),
        EDGE("Microsoft Edge"),
        OPERA("Opera");

        private final String browserName;
    }

    @AllArgsConstructor
    public enum FavoriteDayOfTheWeekDropdown {

        MONDAY("Poniedziałek"),
        TUESDAY("Wtorek"),
        WEDNESDAY("Środa"),
        THURSDAY("Czwartek"),
        FRIDAY("Piątek"),
        SATURDAY("Sobota"),
        SUNDAY("Niedziela");

        private final String dayName;
    }

    @AllArgsConstructor
    public enum AcceptPolicy {

        YES("Tak"),
        NO("Nie");

        private final String value;
    }
}
