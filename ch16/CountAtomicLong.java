package ch16;

import java.util.concurrent.atomic.AtomicLong;

public class CountAtomicLong {
    private AtomicLong count = new AtomicLong(0);

    public void add(long i) {
        IO.println("SUM");
        this.count.getAndUpdate(c -> c + i);
    }

    public void mul(long i) {
        IO.println("Multiple");
        this.count.getAndUpdate(c -> c * i);
    }
}
