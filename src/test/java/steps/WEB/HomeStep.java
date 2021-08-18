package steps.WEB;

import Base.BaseUtil;
import io.cucumber.java.en.Given;
import pages.WEB.HomePage;

import java.io.IOException;

public class HomeStep extends BaseUtil {
    public static HomeStep action() {
        return new HomeStep();
    }

    @Given("I navigate to URL")
    public void iNavigateToURL() throws IOException {
        HomePage.action()
                .openURL();

    }
}
