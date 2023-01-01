package ford.homepage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Header {

    private final SelenideElement modelsLink = $x(".//span[contains(text(),'Modele')]");

    public void expandVehicleModels() {
        modelsLink.click();
    }
}
