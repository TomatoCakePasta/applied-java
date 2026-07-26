package ch6;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

// Compile and Run
// javac -d bin Main.java
// java -cp bin ch6.Main "sample_origin.txt" "sample_copied.gz" 

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            String originFileName = args[0];
            String targetFile = args[1];
            // readPerACharacter(originFileName, targetFile);
            readByBuffer(originFileName, targetFile);
        } catch (Exception e) {
            System.err.println("Input originFileName and targetFile");
            System.exit(1);
        }

    }

    public static void readPerACharacter(String inFile, String outFile) throws IOException {
        FileInputStream fi = new FileInputStream(inFile);
        FileOutputStream fw = new FileOutputStream(outFile);
        GZIPOutputStream zipFw = new GZIPOutputStream(fw);

        int data = fi.read();
        while (data != -1) {
            IO.print((char) data);

            zipFw.write(data);
            data = fi.read();
        }
        zipFw.finish();

        fw.flush();
        fw.close();
        fi.close();
        zipFw.close();
    }

    public static void readByBuffer(String inFile, String outFile) throws IOException {
        // try-with-resources
        try (
                FileInputStream fis = new FileInputStream(inFile);
                FileOutputStream fos = new FileOutputStream(outFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                GZIPOutputStream gzos = new GZIPOutputStream(bos);) {
            int data = fis.read();
            while (data != -1) {
                gzos.write(data);
                data = fis.read();
            }
            gzos.flush();
        } catch (IOException e) {
            IO.println("Failed to read and write file");
        }
    }
}
