package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {
        "src/test/java/features/WEB",
        "src/test/java/features/API"
},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        glue = "steps", monochrome = true, tags = {"@testeSovos"})//, )
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    //@DataProvider
    @DataProvider(parallel = false) // -- For parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
