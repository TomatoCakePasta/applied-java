import java.util.Comparator;

public class BookNameComparator implements Comparator<CorrectBook> {
    public int compare(CorrectBook x, CorrectBook y) {
        return x.getTitle().compareTo(y.getTitle());
    }
}