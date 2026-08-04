package ch16;

// Compile
// javac -d . Main.java CountUpThread.java

// Run
// java ch16.Main  
public class Main {
    void main() {
        Thread t1 = new CountUpThread();
        Thread t2 = new CountUpThread();
        Thread t3 = new CountUpThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
