package Base;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.Markup;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import steps.Hook;
import utilities.Property;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.fail;

/**
 * Created by Karthik on 21/09/2019.
 */

public class BaseUtil {

    public static WebDriver Driver;
    public static ExtentTest scenarioDef;
    public static ExtentTest features;
    public static String reportLocation = "C:\\Users\\Public\\Report";

    public static BaseUtil action() {
        return new BaseUtil();
    }

    public static boolean VerificaObjetoExistente(By Type, WebElement elemento, Boolean Obrigatory, int tentativas) throws InterruptedException {
        for (int i = 0; i < tentativas; i++) {
            try {
                if (elemento != null)
                    if (elemento.isDisplayed() && elemento.isEnabled())
                        return true;

                if (Driver.findElement(Type).isDisplayed() && Driver.findElement(Type).isEnabled())
                    return true;

                if (Obrigatory == false)
                    return true;
            } catch (Exception e) {
                if (tentativas == tentativas - 1 && Obrigatory == true)
                    fail("Não foi possivel verificar a existência do elemento" + elemento);
                Thread.sleep(1000);
            }
        }
        return false;
    }

    public BaseUtil PreencheValorCampoSetSelectButton(By Type, WebElement element_view, String valor, int tentativas) throws InterruptedException {
        for (int i = 0; i < tentativas; i++)
            try {
                if (VerificaObjetoExistente(Type, element_view, true, 1)) {
                    String htmltag = null;
                    String type_element = null;
                    WebElement elementjava = null;

                    if (Type != null) {
                        htmltag = Driver.findElement(Type).getTagName();
                        type_element = Driver.findElement(Type).getAttribute("type");
                        elementjava = Driver.findElement(Type);
                    } else if (element_view != null) {
                        htmltag = element_view.getTagName();
                        type_element = element_view.getAttribute("type");
                        elementjava = element_view;
                    }

                    JavascriptExecutor javaclick = (JavascriptExecutor) Driver;

                    if (type_element != null && type_element.equals("submit"))
                        htmltag = "SUBMIT";

                    if (type_element == null && htmltag.equals("div"))
                        htmltag = "BUTTON";

                    if (htmltag.equals("lib-button"))
                        htmltag = "BUTTON";

                    if (htmltag.equals("td"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("INPUT") && type_element.toUpperCase().trim().equals("IMAGE"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("INPUT") && type_element.toUpperCase().trim().equals("BUTTON"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("INPUT") && type_element.toUpperCase().trim().equals("CHECKBOX"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("INPUT") && type_element.toUpperCase().trim().equals("RADIO"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("H3"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("MAT-CARD"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("MAT-CARD-FOOTER"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("MAT-ICON"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("SPAN"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("B"))
                        htmltag = "BUTTON";

                    switch (htmltag.toUpperCase().trim()) {
                        case "INPUT":
                            if (Type != null) {
                                for (int x = 0; x <= 100; x++) {
                                    try {
                                        Driver.findElement(Type).clear();
                                        if (!Driver.findElement(Type).getAttribute("value").equals("0,00") && !Driver.findElement(Type).getAttribute("value").equals("")) {
                                            Driver.findElement(Type).sendKeys(Keys.ARROW_RIGHT);
                                            Driver.findElement(Type).sendKeys(Keys.BACK_SPACE);
                                        } else {
                                            break;
                                        }
                                    } catch (Exception e) {
                                        break;
                                    }
                                }
                                if (valor != null)
                                    Driver.findElement(Type).sendKeys(valor);
                                else
                                    return new BaseUtil();
                            } else if (element_view != null) {
                                for (int x = 0; x <= 100; x++) {
                                    try {
                                        element_view.clear();
                                        if (!element_view.getAttribute("value").equals("0,00") && !element_view.getAttribute("value").equals("")) {
                                            element_view.sendKeys(Keys.ARROW_RIGHT);
                                            element_view.sendKeys(Keys.BACK_SPACE);
                                        } else {
                                            break;
                                        }
                                    } catch (Exception e) {
                                        break;
                                    }
                                }

                                if (valor != null)
                                    element_view.sendKeys(valor);
                                else
                                    return new BaseUtil();
                            }
                            return new BaseUtil();

                        case "SUBMIT":
                            javaclick.executeScript("arguments[0].click();", elementjava);
                            return new BaseUtil();

                        case "TEXTAREA":
                            if (Type != null) {
                                for (int x = 0; x <= 100; x++) {
                                    if (!Driver.findElement(Type).getAttribute("value").equals("")) {
                                        Driver.findElement(Type).sendKeys(Keys.ARROW_RIGHT);
                                        Driver.findElement(Type).sendKeys(Keys.SPACE);
                                    } else {
                                        break;
                                    }
                                }
                                if (valor != null)
                                    Driver.findElement(Type).sendKeys(valor);
                                else
                                    return new BaseUtil();
                            } else if (element_view != null) {
                                for (int x = 0; x <= 100; x++) {
                                    if (!element_view.getAttribute("value").equals("")) {
                                        element_view.findElement(Type).sendKeys(Keys.ARROW_RIGHT);
                                        element_view.findElement(Type).sendKeys(Keys.SPACE);
                                    } else
                                        break;
                                }

                                if (valor != null)
                                    element_view.sendKeys(valor);
                                else
                                    return new BaseUtil();
                            }

                            if (valor != null)
                                Driver.findElement(Type).sendKeys(valor);
                            return new BaseUtil();

                        case "SELECT":
                            if (Type != null) {
                                Select selectElement = new Select(Driver.findElement(Type));
                                if (valor != null)
                                    selectElement.selectByVisibleText(valor);
                            } else if (element_view != null) {
                                Select selectElement = new Select(element_view);
                                if (valor != null)
                                    selectElement.selectByVisibleText(valor);
                            }
                            return new BaseUtil();

                        case "BUTTON":
                            javaclick.executeScript("arguments[0].click();", elementjava);
                            return new BaseUtil();

                        case "A":
                            javaclick.executeScript("arguments[0].click();", elementjava);
                            return new BaseUtil();

                        default:
                            return new BaseUtil();
                    }
                }
            } catch (Exception e) {
                Thread.sleep(500);
            }
        return new BaseUtil();
    }

    public static ExtentTest logger = null;

    public BaseUtil Report(String status, boolean criarTeste, String nomeTeste, boolean info, String mensagemInfo, String mensagem, boolean flush) {
        try {

            if (criarTeste)
                logger = Hook.extent.createTest(nomeTeste);

            if (info)
                logger.log(Status.INFO, mensagemInfo);

            switch (status) {
                case "PASS":
                    logger.log(Status.PASS, mensagem);
                    break;
                case "FAIL":
                    logger.log(Status.FAIL, "Erro: " + mensagem);
                    break;
                case "SKIP":
                    logger.log(Status.SKIP, "Skip: " + mensagem);
                    break;
                case "INFO":
                    logger.log(Status.INFO, "Info: " + mensagem);
                    break;
                case "PRINT":
                    String temp = takeScreenShot("evidencia.png");
                    logger.info("Evidencia", MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build());
                    break;
                case "END":
                    break;
                default:
                    break;
            }
            if (flush) {
                Properties prop = null;

                if (!Hook.nomeCenario.contains("API") && !Hook.nomeCenario.contains("Banco de Dados")) {
                    String temp = takeScreenShot("evidencia.png");
                    logger.info("Evidencia", MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build());
                }
                Hook.extent.flush();
            }

        } catch (Exception e) {

        }
        return new BaseUtil();
    }

    private String takeScreenShot(String fname) {
        String imageFileDir = "";
        try {
            // Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot = ((TakesScreenshot) Driver);

            // Call getScreenshotAs method to create image file
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

            // imageFileDir = System.getProperty("java.io.tmpdir");
            imageFileDir = System.getProperty("user.dir") + "/Evidencia";
            FileUtils.copyFile(srcFile, new File(imageFileDir, fname));

            byte[] fileContent = FileUtils.readFileToByteArray(srcFile);
            String Base64StringOfScreenshot = "data: image/png;base64," + Base64.getEncoder().encodeToString(fileContent);

            return Base64StringOfScreenshot;
        } catch (Exception e) {
            String txt = e.getMessage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        return null;
    }

    private static int randomiza(int n) {
        return (int) (Math.random() * n);
    }

    private static int mod(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }

    public static String cnpj(boolean comPontos) {
        int n = 9;
        int n1 = randomiza(n);
        int n2 = randomiza(n);
        int n3 = randomiza(n);
        int n4 = randomiza(n);
        int n5 = randomiza(n);
        int n6 = randomiza(n);
        int n7 = randomiza(n);
        int n8 = randomiza(n);
        int n9 = 0; //randomiza(n);
        int n10 = 0; //randomiza(n);
        int n11 = 0; //randomiza(n);
        int n12 = 1; //randomiza(n);
        int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

        d2 = 11 - (mod(d2, 11));

        if (d2 >= 10)
            d2 = 0;

        String retorno = null;

        if (comPontos)
            retorno = "" + n1 + n2 + "." + n3 + n4 + n5 + "." + n6 + n7 + n8 + "/" + n9 + n10 + n11 + n12 + "-" + d1 + d2;
        else
            retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;

        return retorno;
    }

    public static String cpf(boolean comPontos) {
        int n = 9;
        int n1 = randomiza(n);
        int n2 = randomiza(n);
        int n3 = randomiza(n);
        int n4 = randomiza(n);
        int n5 = randomiza(n);
        int n6 = randomiza(n);
        int n7 = randomiza(n);
        int n8 = randomiza(n);
        int n9 = randomiza(n);
        int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

        d2 = 11 - (mod(d2, 11));

        String retorno = null;

        if (d2 >= 10)
            d2 = 0;
        retorno = "";

        if (comPontos)
            retorno = "" + n1 + n2 + n3 + '.' + n4 + n5 + n6 + '.' + n7 + n8 + n9 + '-' + d1 + d2;
        else
            retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;

        return retorno;
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    static final String numbersA = "0123456789";
    static SecureRandom rnd2 = new SecureRandom();

    public static String randomStringNumber(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(numbersA.charAt(rnd2.nextInt(numbersA.length())));
        return sb.toString();
    }

    public static String DataFormating(int diasSoma, String formatacao) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, diasSoma);
        dt = c.getTime();
        DateFormat dateFormat = new SimpleDateFormat(formatacao);
        String strDate = dateFormat.format(dt);
        return strDate;
    }

    public static String SpaceComplete(String textoAdicionarEspaco, int QuantidadeCaracteres) {
        int textoCaracteres = QuantidadeCaracteres;
        int counttexto = textoAdicionarEspaco.length();
        String textoFormatado = textoAdicionarEspaco;
        for (int i = counttexto; i < textoCaracteres; i++)
            textoFormatado = textoFormatado + " ";

        return textoFormatado;
    }

    public static String SpaceCompleteBefore(String textoAdicionarEspaco, int QuantidadeCaracteres) {
        int textoCaracteres = QuantidadeCaracteres;
        int counttexto = textoAdicionarEspaco.length();
        String textoFormatado = textoAdicionarEspaco;
        for (int i = counttexto; i < textoCaracteres; i++)
            textoFormatado = " " + textoFormatado;

        return textoFormatado;
    }

    public static String ZeroAfterComplete(String textoEnviado, int QuantidadeCaracteres) {
        int textoCaracteres = QuantidadeCaracteres;
        int counttexto = textoEnviado.length();
        String textoFormatado = "";
        for (int i = 0; i < textoCaracteres - counttexto; i++)
            textoFormatado = textoFormatado + "0";

        return textoFormatado + textoEnviado;
    }

    public static String ZeroBeforeComplete(String textoEnviado, int QuantidadeCaracteres) {
        int textoCaracteres = QuantidadeCaracteres;
        int counttexto = textoEnviado.length();
        String textoFormatado = "";
        for (int i = 0; i < textoCaracteres - counttexto; i++)
            textoFormatado = "0" + textoFormatado;

        return textoFormatado + textoEnviado;
    }

    public static int aleatoriar(int minimo, int maximo) {
        Random random = new Random();
        return random.nextInt((maximo - minimo) + 1) + minimo;
    }

    // Function to validate
    // GUID (Globally Unique Identifier)
    // using regular expression
    public static boolean isValidGUID(String str) {
        // Regex to check valid
        // GUID (Globally Unique Identifier)
        String regex
                = "^[{]?[0-9a-fA-F]{8}"
                + "-([0-9a-fA-F]{4}-)"
                + "{3}[0-9a-fA-F]{12}[}]?$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }

        // Find match between given string
        // and regular expression
        // uSing Pattern.matcher()

        Matcher m = p.matcher(str);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }
    public static String readJsonMass(String file, String fatherLocation, String field) throws FileNotFoundException {
        JsonObject jsonObject = new JsonParser().parse(new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\JSON\\" + file)).getAsJsonObject();
        String item = jsonObject.getAsJsonObject(fatherLocation).get(field).getAsString();
        System.out.println(item);
        return item;
    }

}




