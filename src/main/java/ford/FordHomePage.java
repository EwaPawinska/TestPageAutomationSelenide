package ford;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ford.homepage.Header;
import ford.homepage.VehicleMenu;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class FordHomePage {
    private final Header header = new Header();
    private final VehicleMenu vehicleMenu = new VehicleMenu();
    private final SelenideElement acceptCookiesButton = $x(".//a[contains(text(),'Akceptuję')]");

    public void openFordHomepage() {
        Selenide.open("https://www.ford.pl/");
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }
}
