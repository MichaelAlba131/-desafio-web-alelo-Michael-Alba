package JSON;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Students {

    private String name;
    private String cpf;
    private String email;
    private Integer years;
    //private List<String> book;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

//    public List<String> getBook() {
//        return book;
//    }
//
//    public void setBooks(List<String> book) {
//        this.book = book;
//    }
}
