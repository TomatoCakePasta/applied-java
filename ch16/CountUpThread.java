package ch16;

import java.util.concurrent.TimeUnit;

public class CountUpThread extends Thread {
    public void run() {
        for (int i = 1; i <= 50; i++) {
            IO.print(i + "..");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {

            }
        }
    }
}
