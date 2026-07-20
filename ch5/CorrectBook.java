import java.util.*;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.lang3.builder.*;

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
        return EqualsBuilder.reflectionEquals(this, o);
    }
    
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    @Override
    public int compareTo(CorrectBook obj) {
        return CompareToBuilder.reflectionCompare(this, obj, "comment", "title");
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