import java.util.Date;

public record RecordBook(String title, Date publishDate, String comment) 
    implements Comparable<RecordBook>, Cloneable {
    public RecordBook { 
        if (publishDate == null) { 
            throw new IllegalArgumentException("publishDate cannot be null"); 
        }
    } 
    
    // 以下は自動で定義される
    // 全フィールドを受け取るコンストラクタ
    // getter
    // toString, equals, hashCode
    
    @Override
    public int compareTo(RecordBook other) {
        return this.title.compareTo(other.title);
    }
}