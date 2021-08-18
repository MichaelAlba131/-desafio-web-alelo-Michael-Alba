package steps;

import Base.BaseUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.*;
import org.junit.Assume;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Hook extends BaseUtil {

    private final BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @SuppressWarnings("deprecation")
    public static ExtentHtmlReporter reporter;
    public static ExtentReports extent;
    public static int vezPercorrida = 0;
    public static String nomeCenario = null;

    @Before
    public void InitializeTest(Scenario scenario) throws IOException {

        nomeCenario = scenario.getName();

        String strDate = BaseUtil.DataFormating(0, "ddMMyyyy-HHmmss");

        if (vezPercorrida == 0) {
            //noinspection deprecation
            reporter = new ExtentHtmlReporter("src/test/java/Reports/report_" + strDate + ".html");
            reporter.config().setDocumentTitle("Automation QA");
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setReportName("Automation QA Report");

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        vezPercorrida++;

        BaseUtil.action()
                .Report("PASS", true, Hook.nomeCenario, false, null, Hook.nomeCenario + " - Sucesso!", false);

        if (!nomeCenario.contains("API")) {
            System.out.println("Opening the browser : Chrome");
            //Chrome driver
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

            Map<String, Object> prefs = new HashMap<String, Object>();
            //String path = System.getProperty("user.dir") + "\\Reports\\DownloadTerms";
            //prefs.put("download.default_directory", path);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            Driver = new ChromeDriver(options);

            Driver.manage().window().maximize();
            Driver.manage().deleteAllCookies();
        }
    }

    @After
    public void TearDownTest(Scenario scenario) {
        // if (scenario.isFailed()) {
        // }

        BaseUtil.action()
                .Report("END", false, "End Tests", false, null, null, true);

        if (!nomeCenario.contains("API") && !nomeCenario.contains("Banco de Dados")) {
            System.out.println("Closing the Browser");
            Driver.quit();
        }
    }

    @Before("@skip_scenario")
    public void skip_scenario(Scenario scenario) {
        System.out.println("SKIP SCENARIO: " + scenario.getName());
        Assume.assumeTrue(false);
    }

    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        System.out.println("Before every step " + scenario.getId());
    }


    @AfterStep
    public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
        //System.out.println("Before every step " + stepTestStep.getId());
    }

}
