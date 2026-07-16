public class Main {
    public static void main(String[] args) {
        // define class using generics
        StrongBox<String> stBox = new StrongBox<>();
        
        stBox.put("Hello World");
        IO.println(stBox.get());
    }
}