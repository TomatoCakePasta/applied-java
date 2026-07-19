import java.lang.reflect.*;
import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {
        String fqcn = "java.lang.String"; // args[0];
        String sw = "I"; // args[1];
        
        showMemory();
        
        try {
            Class<?> clazz = Class.forName(fqcn);
            listMethods(clazz);
            
            if ("E".equals(sw)) {
                launchExternal(clazz);
            }
            else if ("I".equals(sw)) {
                launchInternal(clazz);
            }
            else {
                throw new IllegalArgumentException("起動方法の指定が不正です");
            }
        }
        catch (Exception e) {
            IO.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        showMemory();
        System.exit(0);
    }    
    
    public static void listMethods(Class<?> clazz) {
        IO.println("\n ===== Display " + clazz.getName() + " list =====");
        Method[] methods = clazz.getDeclaredMethods();
        
        Arrays.stream(methods)
            .forEach(c -> IO.println(c.getName()));
    }
    
    public static void launchExternal(Class<?> clazz) throws Exception {
        IO.println("\n ===== launchExternal =====");
        // run following command
        // $ java Main
        ProcessBuilder pb = new ProcessBuilder("java", clazz.getName());
        Process proc = pb.start();
        
        // waiting until finishing process
        proc.waitFor();
    }
    
    public static void launchInternal(Class<?> clazz) throws Exception {
        IO.println("\n ===== launchInternal =====");
        Method m = clazz.getMethod("main", String[].class);
        String[] args = {};
        m.invoke(null, (Object)args);
    }
    
    public static void showMemory() {
        long free = Runtime.getRuntime().freeMemory();
        long total = Runtime.getRuntime().totalMemory();
        long usage = (total - free) / 1024 /1024;
        IO.println("Current memory usage: " + usage + "MB");
    }
}