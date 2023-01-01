package pagetoautomate.homepage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SecondForm {

    private final SelenideElement DelayedButton = $("span[class = 'elementor-button-text']");
}
