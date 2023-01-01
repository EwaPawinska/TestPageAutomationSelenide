package pagetoautomate.homepage;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class FirstForm {

    private final SelenideElement firstNameInput = $("input[name*='firstname']");
    private final SelenideElement secondNameInput = $("#secondname-text");
    private final SelenideElement lastNameInput = $("#lastname-text");
    private final SelenideElement optionRadio = $("input[name='option']");
    private final SelenideElement dayOfTheWeekDropdown = $("select[name='dayOfTheWeek']");
    private final SelenideElement browserMultiSelect = $("select[id='browser-select-multiple']");

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

        MONDAY("Pooniedziałek"),
        TUESDAY("Wtorek"),
        WEDNESDAY("Środa"),
        THURSDAY("Czwartek"),
        FRIDAY("Piątek"),
        SATURDAY("Sobota"),
        SUNDAY("Niedziela");

        private final String dayName;
    }
}
