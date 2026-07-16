import java.util.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        Book book = new Book("Title", date, "Comment");
        Book book2 = new Book("Title", date, "Comment");
        IO.println("book1: \n" + book);
        IO.println("book2: \n" + book2 + "\n");
        
        // デフォルトはObject.equals()が実行される
        // Object.equals()は等値判定を行い、アドレスが異なるためfalseになる
        // 本来はインスタンスの中身を比較する等価判定を行いたい
        IO.println("book.equals(book2): " + book.equals(book2) + "\n");
        
        // equalsをオーバーライドしたもの
        CorrectBook cBook = new CorrectBook("Title", date, "Comment");
        CorrectBook cBook2 = new CorrectBook("Title", date, "Comment");
        
        IO.println("cBook1: \n" + cBook);
        IO.println("cBook2: \n" + cBook2 + "\n");
        
        // 正しく等価判定を行っている
        IO.println("cBook.equals(cBook2): " + cBook.equals(cBook2) + "\n");
        
        Set<Book> list = new HashSet<>();
        list.add(book);
        IO.println("size: " + list.size());
        
        Book rmBook = new Book("Title", date, "Comment");
        // rmBookと中身が同じものを削除したい
        list.remove(rmBook);
        // できていない
        IO.println("remove size: " + list.size() + "\n");
        
        // hashCodeをオーバーライド
        Set<CorrectBook> cList = new HashSet<>();
        cList.add(cBook);
        IO.println("cSize: " + cList.size());
        
        CorrectBook cRmBook = new CorrectBook("Title", date, "Comment");
        cList.remove(cRmBook);
        IO.println("remove cSize: " + cList.size());
    }
}