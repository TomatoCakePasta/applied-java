import java.util.*;

public class MemoryEater {
    public static void main(String[] args) {
        if (Locale.getDefault().getLanguage().equals("ja")) {
            IO.println("メモリを消費しています");
        }
        else {
            IO.println("Eating memory ...");
        }

        long[] larray = new long[1280000];
        for (int i = 0; i < larray.length; i++) {
            larray[i] = i;
        }
    }
}