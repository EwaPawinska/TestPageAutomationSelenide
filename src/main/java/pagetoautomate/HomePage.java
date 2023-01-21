package pagetoautomate;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import pagetoautomate.homepage.FirstForm;
import pagetoautomate.homepage.SecondForm;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePage {

    private final FirstForm firstForm = new FirstForm();
    private final SecondForm secondForm = new SecondForm();
    private final SelenideElement acceptCookiesButton = $("a#cn-accept-cookie");

    public void acceptCookies() {
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }
    }
}
