import java.io.OutputStream;
import java.net.Socket;

public class Mail {
    public static void main(String[] args) {
        Socket sock = new Socket("smtp.example.com", 60025);
        OutputStream os = sock.getOutputStream();
        os.write("HELLO smtp.example.com¥n¥r".getBytes());
        os.flush();
        sock.close();
    }
}
