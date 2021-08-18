package JSON;

public class Books {

    private String author;
    private String name;
    private String title;

    public Books(String author, String name, String title) {
        this.author = author;
        this.name = name;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
