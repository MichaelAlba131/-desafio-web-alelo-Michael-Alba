package pages.API;

import Base.BaseUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import steps.Hook;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;

public class APIGETMethodPage {

    @Before
    public void setUp() {
        //Configurações Rest-Assured
        baseURI = "http://localhost:8080";
    }

    public static APIGETMethodPage action() {
        return new APIGETMethodPage();
    }

    public static Response result = null;
    public static String responseText = null;

    public APIGETMethodPage GetMethod(String cenary) {
        String tracker = "/students";

        result = APIPage.action().GETMethod(tracker);
        responseText = result.prettyPrint();

        BaseUtil.action()
                .Report("INFO", false, Hook.nomeCenario, false, null, "URI: " + baseURI + tracker, false);

        if (APIPage.action().ValidateStatusCode(result)) {
            BaseUtil.action()
                    .Report("PASS", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

            BaseUtil.action()
                    .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);

            switch (cenary) {
                case "001 - API - return notifications for the following countries: BR, AR":
                    if (ValidateCenaryPage.VerifyCountries(responseText))
                        BaseUtil.action()
                                .Report("PASS", false, Hook.nomeCenario, false, null, "Countries found with your notifications", false);
                    break;
            }

        } else
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Status Code URI + tracker: " + result.getStatusCode() + "| Response: " + result.prettyPrint(), false);


        return new APIGETMethodPage();
    }

    public static void PostMethod(String cenary) throws IOException, InterruptedException {
        String tracker = "/students";

        result = APIPage.action().POSTMethod(tracker);
        responseText = result.prettyPrint();

        BaseUtil.action()
                .Report("INFO", false, Hook.nomeCenario, false, null, "URI: " + baseURI + tracker, false);

        if (APIPage.action().ValidateStatusCode(result)) {
            BaseUtil.action()
                    .Report("PASS", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

            BaseUtil.action()
                    .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);

        }
    }
}

