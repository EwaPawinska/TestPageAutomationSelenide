package pagetoautomate;

import lombok.Getter;
import pagetoautomate.homepage.FirstForm;
import pagetoautomate.homepage.SecondForm;

import static com.codeborne.selenide.Condition.interactable;

@Getter
public class HomePage {

    private final FirstForm firstForm = new FirstForm();
    private final SecondForm secondForm = new SecondForm();

    public void verifyAllWebElementsAreDisplayed() {
        secondForm.getDelayedButton().shouldBe(interactable);
    }
}
