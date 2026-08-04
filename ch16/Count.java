package ch16;

public class Count {
    private long count = 0;

    public void add(long i) {
        IO.println("SUM");
        synchronized (this) {
            this.count += 1;
        }
    }

    public void mul(long i) {
        IO.println("Multiple");
        synchronized (this) {
            this.count *= i;
        }
    }
}
