package pages.WEB;

import Base.BaseUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import steps.Hook;
import utilities.Property;

import java.util.Properties;

import static Base.BaseUtil.Driver;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static HomePage action() {
        return new HomePage(Driver);
    }

    /**
     * Go to URL
     */
    public HomePage openURL() {
        try {
            Properties prop = Property.getProp();
            String url = prop.getProperty("url");

            Driver.navigate().to(url);

            BaseUtil.action()
                    .Report("INFO", false, Hook.nomeCenario, false, null, "Browser Navigate to URL: " + url, false);

        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Browser Fail to Navigate to URL", false);

        }
        return new HomePage(Driver);
    }
}
