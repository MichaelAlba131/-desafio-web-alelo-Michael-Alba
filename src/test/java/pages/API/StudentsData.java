package pages.API;

import Base.BaseUtil;
import JSON.Students;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

public class StudentsData {

    public static Students createNewStudent() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Students students = objectMapper.readValue(new FileInputStream("src/test/resources/requestBody/createStudents.json"), Students.class);

        return students;
    }


    public static Students updateStudent() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Students students = objectMapper.readValue(new FileInputStream("src/test/resources/requestBody/updateStudents.json"), Students.class);
        return students;
    }

    public static Students usuarioCPFNovo() throws IOException, InterruptedException {
        Students user = createNewStudent();
        user.setCpf(BaseUtil.cpf(true));

        return user;
    }


}
