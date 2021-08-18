package pages.API;

import JSON.Students;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APIPage {
    public static APIPage action() {
        return new APIPage();
    }

    public Response POSTMethod(String URI) throws IOException, InterruptedException {
       Students newStudent = StudentsData.usuarioCPFNovo();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(newStudent)
                .when()
                .post(URI)
                .then()
                .assertThat()
                .extract().response();

        return response;
    }

    public Response GETMethod(String URI) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(URI)
                .then()
                .assertThat()
                .extract().response();

        return response;
    }

    public Response PatchMethod(String URI) throws IOException {

        Students updateStudent = StudentsData.updateStudent();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(updateStudent)
                .when()
                .patch(URI)
                .then()
                .assertThat()
                .extract().response();

        return response;
    }


    public Response POSTMethod_(String URI) throws IOException {
        JsonObject jsonObject = new JsonParser().parse(new FileReader("src/test/resources/requestBody/createStudents2.json")).getAsJsonObject();
        String item = jsonObject.toString();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(item)
                .when()
                .post(URI)
                .then()
                .assertThat()
                .extract().response();

        return response;
    }

    public boolean ValidateStatusCode(Response response) {
        switch (response.getStatusCode()) {
            case 200:
                //OK
                return true;
            case 201:
                //Criado
                return true;
            case 202:
                //Aceito
                return true;
            case 204:
                //Sem Conteudo - Qualquer metainformação nova ou atualizada deve ser aplicada ao documento atualmente na visão dinâmica do agente do usuário.
                return false;
            case 301:
                //Movido Permanentemente - Precisa especificar a nova URI.
                return false;
            case 302:
                //Encontrado - especificam que o cliente não tem permissão para alterar o método na solicitação redirecionada.
                return false;
            case 303:
                //Ver Outro - indica que um recurso de controlador concluiu seu trabalho, mas em vez de enviar um corpo de resposta potencialmente indesejado, ele envia ao cliente o URI de um recurso de resposta.
                return false;
            case 304:
                //Ver Outro - quando o recurso não foi modificado desde a versão especificada pelos cabeçalhos de solicitação If-Modified-Since ou If-None-Match.
                return false;
            case 404:
                return false;
            case 503:
                return false;
            default:
                return false;
        }
    }

}