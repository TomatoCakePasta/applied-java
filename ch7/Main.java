import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.Properties;
import java.util.ResourceBundle;

// Run
// % java -cp bin:. Main

public class Main {
    public static void main(String[] args) throws Exception {
        readFileByProperties();

        readFileByResourceBundle();

        ObjectSaveBySerialize();
    }

    public static void readFileByProperties() throws Exception {
        Reader fr = new FileReader("pref.properties");
        Properties p = new Properties();
        p.load(fr);
        IO.println(p.getProperty("kanagawa.capital") + " : " + p.getProperty("kanagawa.food"));
        fr.close();
    }

    public static void readFileByResourceBundle() throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("pref");
        IO.println(rb.getString("kanagawa.capital") + " : " + rb.getString("kanagawa.food"));

    }

    public static void ObjectSaveBySerialize() throws Exception {
        Employee e = new Employee("田中太郎", 21);
        Department d = new Department("人事部", e);

        // Store
        FileOutputStream fos = new FileOutputStream("company.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);
        oos.flush();
        oos.close();

        IO.println("===== Store =====");
        printDepartment(d);

        // Restore
        FileInputStream fis = new FileInputStream("company.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Department d2 = (Department) ois.readObject();
        IO.println("===== Restore =====");
        printDepartment(d2);

    }

    public static void printDepartment(Department d) {
        IO.println("Department: " + d.getDepartmentName() + ", " + d.getEmployee());
    }
}
