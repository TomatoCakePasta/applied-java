import java.util.*;
import java.util.Date;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        
        // equalsの確認
        testEquals();
        
        // HashSetとequals/hashCodeの確認
        testHashSet();
        
        // Comparableによる並び替え
        testSort();
        
        // Comparatorによる並び替え
        testComparatorSort();
        
        // cloneによるインスタンス複製
        testClone();

        // レコード
        testRecord();
    }
    
    /**
     * equals()の動作を確認
     */
    public static void testEquals() {
        IO.println("===== equals()の動作を確認 =====");
        
        Date date = new Date();
        
        // equalsをオーバーライドしていないBook
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
    }
    
    /**
     * HashSetとequals/hashCodeの動作を確認
     */
    public static void testHashSet() {
        IO.println("===== HashSetとequals/hashCodeの動作を確認 =====");
        
        Date date = new Date();
        
        // hashCodeをオーバーライド
        Set<CorrectBook> cList = new HashSet<>();
        CorrectBook cBook = new CorrectBook("Title", date, "Comment");
        cList.add(cBook);
        IO.println("cSize: " + cList.size());
        
        CorrectBook cRmBook = new CorrectBook("Title", date, "Comment");
        cList.remove(cRmBook);
        IO.println("remove cSize: " + cList.size() + "\n");
    }
    
    /**
     * Comparableによる並び替えを確認
     */
    public static void testSort() {
        IO.println("===== Comparableによる並び替えを確認 =====");
        
        Date date = new Date();
        
        // 並び替え
        Book book = new Book("Title", new Date(2026, 2, 3), "Comment");
        Book book2 = new Book("Title", new Date(2026, 1, 2), "Comment");
        
        List<Book> sortList = new ArrayList<>();
        sortList.add(book);
        sortList.add(book2);
        IO.println("Before sortList:");
        printList(sortList);
        
        // エラーが起きる
        // デフォルトだと、JVMがどの項目で並び替えをすればいいか分からないため
        // Collections.sort(sortList);
        IO.println("Error: Collections.sort(sortList) \n");
        
        // Comparableインタフェースの実装
        CorrectBook cBook = new CorrectBook("Title", new Date(2026, 2, 3), "Comment");
        CorrectBook cBook2 = new CorrectBook("Title", new Date(2026, 1, 2), "Comment");
        List<CorrectBook> sortCList = new ArrayList<>();
        sortCList.add(cBook);
        sortCList.add(cBook2);
        
        IO.println("Before sortCList:");
        printList(sortCList);
        
        // 古い順に並び変わる
        Collections.sort(sortCList);
        IO.println("After sortCList:");
        printList(sortCList);
    }
    
    /**
     * Comparatorによる並び替えを確認
     */
    public static void testComparatorSort() {
        Date date = new Date();
        
        IO.println("===== Comparatorによる並び替えを確認 =====");
        
        // Comparableインタフェースの実装
        CorrectBook cBook = new CorrectBook("BananaBook", new Date(2026, 2, 3), "Comment");
        CorrectBook cBook2 = new CorrectBook("AppleBook", new Date(2026, 1, 2), "Comment");
        List<CorrectBook> sortCList = new ArrayList<>();
        sortCList.add(cBook);
        sortCList.add(cBook2);
        
        IO.println("Before sortCList:");
        printList(sortCList);
        
        // 書名に並び変わる
        Collections.sort(sortCList, new BookNameComparator());
        IO.println("After sortCList:");
        printList(sortCList);
    }
    
    /**
     * cloneによるインスタンス複製を確認
     */
    public static void testClone() {
        IO.println("===== cloneによるインスタンス複製を確認 =====");
        
        // インスタンス複製の検証
        Book cloneBook = new Book("Title", new Date(2026, 2, 3), "Comment");
        Book cloneBook2 = cloneBook;
        // アドレスをコピーしただけのため、インスタンス自体は1つのままである
        IO.println("isBookCloned: " + !(cloneBook == cloneBook2));
        
        CorrectBook cloneCBook = new CorrectBook("Title", new Date(2026, 2, 3), "Comment");
        CorrectBook cloneCBook2 = cloneCBook.clone();
        IO.println("isCorrectBookCloned: " + !(cloneCBook == cloneCBook2));
    }

    /**
     * レコード
     */
    public static void testRecord() {
        IO.println("===== レコード =====");
        RecordBook rBook = new RecordBook("AppleBook", new Date(2026, 1, 2), "Apple");
        RecordBook rBook2 = new RecordBook("BananaBook", new Date(2027, 3, 4), "Banana");
        
        try {
            RecordBook rBook3 = new RecordBook("ChocolateBook", null, "Chocolate");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
       
        IO.println("rBook.title: " + rBook.title());
    }
    
    /**
     * Listの内容を表示
     */
    public static void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            IO.println("elem " + i + ": " + list.get(i));
        }
        IO.println("\n");
    }
}