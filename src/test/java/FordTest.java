import ford.FordHomePage;
import org.junit.Test;

public class FordTest extends TestBase{

    private final FordHomePage fordHomePage = new FordHomePage();

    @Test
    public void openFordHomePage() {
        fordHomePage.openFordHomepage();
        fordHomePage.acceptCookies();
        fordHomePage.getHeader().expandVehicleModels();
        fordHomePage.getVehicleMenu().verifyVehicleMenuIsVisible();
    }
}
