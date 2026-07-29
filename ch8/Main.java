import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://dokojava.jp/favicon.ico");

        InputStream in = url.openStream();
        FileOutputStream out = new FileOutputStream("dj.ico");

        try {
            pipe(in, out);
        } finally {
            out.close();
            in.close();
        }
    }

    public static void pipe(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[1024];
        int len = 0;

        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
    }
}