package pages.WEB;

import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import steps.Hook;
import static org.junit.Assert.fail;
import static Base.BaseUtil.Driver;


public class HomeCepPage {
    public HomeCepPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static HomeCepPage action() {
        return new HomeCepPage(Driver);
    }

    @FindBy(how = How.ID, using = "endereco")
    public WebElement enderecoCEP;

    @FindBy(how = How.NAME, using = "tipoCEP")
    public WebElement filterSearchCEP;

    @FindBy(how = How.ID, using = "btn_pesquisar")
    public WebElement btnSearchCEP;

    @FindBy(how = How.ID, using = "resultado-DNEC")
    public WebElement tableCEPSearched;

    public HomeCepPage Fill_CEP(String cep) throws InterruptedException {

        BaseUtil.action().PreencheValorCampoSetSelectButton(null, enderecoCEP, cep, 10);

        BaseUtil.action()
                .Report("INFO", false, Hook.nomeCenario, false, null, "Fill the CEP | CEP: " + cep, false);

        return new HomeCepPage(Driver);
    }

    public HomeCepPage SelectFilterSearch(String filter) throws InterruptedException {
        try {
            BaseUtil.action().PreencheValorCampoSetSelectButton(null, filterSearchCEP, filter, 10);

            BaseUtil.action()
                    .Report("INFO", false, Hook.nomeCenario, false, null, "Select the type of search for CEP | Option: " + filter, false);
        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Fail to select the type of search for CEP | Option: " + filter, false);

        }
        return new HomeCepPage(Driver);
    }

    public HomeCepPage ClickSearch() {
        try {
            BaseUtil.action().PreencheValorCampoSetSelectButton(null, btnSearchCEP, null, 10);
            BaseUtil.action()
                    .Report("INFO", false, Hook.nomeCenario, false, null, "Click search CEP button", false);

        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Fail to click search CEP", false);

        }
        return new HomeCepPage(Driver);
    }

    public HomeCepPage ValidateSearchReturn(String ID) {
        try {
            String logradouro = "";
            String bairro = "";
            String localidade = "";
            String cep = "";

            String logradouroJson = BaseUtil.readJsonMass("src/test/resources/requestBody/ValidationCEP.json", ID, "Logradouro/Nome");
            String bairroJson = BaseUtil.readJsonMass("src/test/resources/requestBody/ValidationCEP.json", ID, "Bairro/Distrito");
            String localidadeJson = BaseUtil.readJsonMass("src/test/resources/requestBody/ValidationCEP.json", ID, "Localidade/UF");
            String cepJson = BaseUtil.readJsonMass("src/test/resources/requestBody/ValidationCEP.json", ID, "CEP");

            String[] logradouroJsonItens = logradouroJson.split(",");
            String[] bairroJsonItens = bairroJson.split(",");
            String[] localidadeJsonItens = localidadeJson.split(",");
            String[] cepJsonItens = cepJson.split(",");


            BaseUtil.VerificaObjetoExistente(null, tableCEPSearched, true, 30);
            int i = 0;

            if (tableCEPSearched.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size() != logradouroJsonItens.length) {
                BaseUtil.action()
                        .Report("FAIL", false, Hook.nomeCenario, false, null,
                                "The itens of system does not correspond to expected | Public itens system: " + tableCEPSearched.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size() + " | Public itens JSON: " +
                                        logradouroJsonItens.length + " | " + logradouroJson, false);
                System.out.print("The itens of system does not correspond to expected | Public itens system: " + tableCEPSearched.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size() + " | Public itens JSON: " +
                        logradouroJsonItens.length);
                fail();
            }

            for (WebElement el : tableCEPSearched.findElement(By.tagName("tbody")).findElements(By.tagName("tr"))) {
                logradouro = el.findElements(By.tagName("td")).get(0).getText();
                bairro = el.findElements(By.tagName("td")).get(1).getText();
                localidade = el.findElements(By.tagName("td")).get(2).getText();
                cep = el.findElements(By.tagName("td")).get(3).getText();

                if (!logradouro.equals(logradouroJsonItens[i])) {
                    BaseUtil.action()
                            .Report("FAIL", false, Hook.nomeCenario, false, null,
                                    "Public place does not correspond to expected | Public place system: " + logradouro + " | Public place JSON: " +
                                            logradouroJsonItens[i], false);
                    System.out.print("Public place does not correspond to expected | Public place system: " + logradouro + " | Public place JSON: " +
                            logradouroJsonItens[i]);
                    fail();
                } else {
                    BaseUtil.action()
                            .Report("PASS", false, Hook.nomeCenario, false, null,
                                    "Public place correspond to expected | Public place system: " + logradouro + " | Public place JSON: " +
                                            logradouroJsonItens[i], false);
                    System.out.print("Public place correspond to expected | Public place system: " + logradouro + " | Public place JSON: " +
                            logradouroJsonItens[i]);

                }

                if (!bairro.equals(bairroJsonItens[i])) {
                    BaseUtil.action()
                            .Report("FAIL", false, Hook.nomeCenario, false, null,
                                    "Neighborhood does not correspond to expected | Neighborhood system: " + bairro + " | Neighborhood JSON: " +
                                            bairroJsonItens[i], false);
                    System.out.print("Neighborhood does not correspond to expected | Neighborhood system: " + bairro + " | Neighborhood JSON: " +
                            bairroJsonItens[i]);
                    fail();
                } else {
                    BaseUtil.action()
                            .Report("PASS", false, Hook.nomeCenario, false, null,
                                    "Neighborhood correspond to expected | Neighborhood system: " + bairro + " | Neighborhood JSON: " +
                                            bairroJsonItens[i], false);
                    System.out.print("Neighborhood correspond to expected | Neighborhood system: " + bairro + " | Neighborhood JSON: " +
                            bairroJsonItens[i]);

                }

                if (!localidade.equals(localidadeJsonItens[i])) {
                    BaseUtil.action()
                            .Report("FAIL", false, Hook.nomeCenario, false, null,
                                    "Location does not match expected | Location system: " + localidade + " | Location JSON: " +
                                            localidadeJsonItens[i], false);
                    System.out.print("Location does not match expected | Location system: " + localidade + " | Location JSON: " +
                            localidadeJsonItens[i]);
                    fail();
                } else {
                    BaseUtil.action()
                            .Report("PASS", false, Hook.nomeCenario, false, null,
                                    "Location match expected | Location system: " + localidade + " | Location JSON: " +
                                            localidadeJsonItens[i], false);
                    System.out.print("Location match expected | Location system: " + localidade + " | Location JSON: " +
                            localidadeJsonItens[i]);

                }

                if (!cep.equals(cepJsonItens[i])) {
                    BaseUtil.action()
                            .Report("FAIL", false, Hook.nomeCenario, false, null,
                                    "CEP does not correspond to expected | CEP system: " + logradouro + " | CEP JSON: " +
                                            cepJsonItens[i], false);
                    System.out.print("CEP does not correspond to expected | CEP system: " + logradouro + " | CEP JSON: " +
                            cepJsonItens[i]);
                    fail();
                } else {
                    BaseUtil.action()
                            .Report("PASS", false, Hook.nomeCenario, false, null,
                                    "CEP correspond to expected | CEP system: " + logradouro + " | CEP JSON: " +
                                            cepJsonItens[i], false);
                    System.out.print("CEP correspond to expected | CEP system: " + logradouro + " | CEP JSON: " +
                            cepJsonItens[i]);

                }

                i++;
            }


        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Fail Validations for the  CEP", false);

        }
        return new HomeCepPage(Driver);
    }
}
