import java.util.*;
import java.util.Date;
import java.util.Objects;

public class CorrectBook implements Comparable<CorrectBook>, Cloneable {
    private String title;
    private Date publishDate;
    
    private String comment;
    
    public CorrectBook(String title, Date publishDate, String comment) {
        this.title = title;
        this.publishDate = publishDate;
        this.comment = comment;
    }
    
    public CorrectBook() {
        this("", null, "");
    }
    
    public String getTitle() {
        return title;
    }
    
    public String toString() {
        return "Title: " + title + " Date: " + publishDate + " Comment: " + comment;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        
        if (o == null) {
            return false;
        }
        
        if (!(o instanceof CorrectBook)) {
            return false;
        }
        
        CorrectBook r = (CorrectBook)o;
        
        if (!this.title.equals(r.title) || !this.publishDate.equals(r.publishDate)) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(title, publishDate);
    }
    
    @Override
    public int compareTo(CorrectBook obj) {
        return publishDate.compareTo(obj.publishDate);
    }
    
    @Override
    public CorrectBook clone() {
        CorrectBook result = new CorrectBook();
        result.title = title;
        result.publishDate = publishDate;
        result.comment = comment;
        
        return result;
    }
}