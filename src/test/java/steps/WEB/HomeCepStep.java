package steps.WEB;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.WEB.HomeCepPage;
import steps.Hook;

public class HomeCepStep extends BaseUtil {
    public static HomeCepStep action() {
        return new HomeCepStep();
    }

    @And("I fill the CEP and search {string}{string}")
    public void i_fill_the_CEP_and_search(String cep, String filter) throws InterruptedException {
        HomeCepPage.action()
                .Fill_CEP(cep)
                .SelectFilterSearch(filter)
                .ClickSearch();
    }


    @And("I validate the information returned with the JSON file {string}")
    public void iValidateTheInformationReturnedWithTheJSONFile(String idJson) {
        HomeCepPage.action()
                .ValidateSearchReturn(idJson);

    }
}
