package steps.API;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pages.API.APIGETMethodPage;
import pages.API.APIPage;
import steps.Hook;

import java.io.IOException;
import java.util.Locale;

public class APIGetStep {
    public static APIGetStep action() {
        return new APIGetStep();
    }

    public static String responseText = null;

    @Given("I realizing a Get Method and validate a {string}")
    public void iRealizingAGetMethod(String cenary) throws IOException, InterruptedException {
        APIGETMethodPage.PostMethod(cenary);
    }

    @Given("crio um novo estudante {string}")
    public void crioUmNovoEstudante(String criacao) throws IOException, InterruptedException {
        if (criacao.toUpperCase().trim().equals("TRUE")) {
            Response result = APIPage.action().POSTMethod("/students");
            responseText = result.prettyPrint();
            if (result.getStatusCode() == 201) {
                BaseUtil.action()
                        .Report("PASS", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);
            } else {
                BaseUtil.action()
                        .Report("FAIL", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);

            }
        }
    }

    @And("atualizo o nome e email {string}")
    public void atualizoONomeEEmail(String atualizacao) throws IOException {
        if (atualizacao.toUpperCase().trim().equals("TRUE")) {
            Response result = APIPage.action().PatchMethod("/students/09705066619");
            responseText = result.prettyPrint();

            if (result.getStatusCode() == 200) {
                BaseUtil.action()
                        .Report("PASS", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);
            } else {
                BaseUtil.action()
                        .Report("FAIL", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);

            }
        }
    }

    @Then("consulto todos os cadastros na base {string}")
    public void consultoTodosOsCadastrosNaBase(String consulta) {
        if (consulta.toUpperCase().trim().equals("TRUE")) {
            Response result = APIPage.action().GETMethod("/students");
            responseText = result.prettyPrint();
            if (result.getStatusCode() == 200) {
                BaseUtil.action()
                        .Report("PASS", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);
            } else {
                BaseUtil.action()
                        .Report("FAIL", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);

            }
        }
    }

    @Given("crio um novo estudante {string}{string}")
    public void crioUmNovoEstudante(String criacao, String CPFDuplicado) throws IOException {
        if (criacao.toUpperCase().trim().equals("TRUE")) {
            Response result = APIPage.action().POSTMethod_("/students");
            responseText = result.prettyPrint();
            if (result.getStatusCode() == 201 || CPFDuplicado.toUpperCase().trim().equals("TRUE") && result.getStatusCode() == 400) {
                BaseUtil.action()
                        .Report("PASS", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);
            } else {
                BaseUtil.action()
                        .Report("FAIL", false, Hook.nomeCenario, false, null, "Status Code: " + result.getStatusCode(), false);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Response: " + responseText + "</pre>", false);

            }
        }
    }
}
