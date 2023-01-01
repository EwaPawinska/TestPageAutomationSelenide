package ford.homepage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class VehicleMenu {

    private final SelenideElement passengerCarLink =
            $x(".//ul[@class = 'vehicle-menu']//a[contains(text(), 'Osobowe')]").as("Osobowe");

    public void verifyVehicleMenuIsVisible() {
        passengerCarLink.shouldBe(visible);
    }
}
