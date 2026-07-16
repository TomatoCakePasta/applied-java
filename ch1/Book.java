import java.util.*;
import java.util.Date;

public class Book {
    private String title;
    private Date publishDate;
    private String comment;
    
    public Book(String title, Date publishDate, String comment) {
        this.title = title;
        this.publishDate = publishDate;
        this.comment = comment;
    }
    
    public String toString() {
        return "Title: " + title + " Date: " + publishDate + " Comment: " + comment;
    }
}