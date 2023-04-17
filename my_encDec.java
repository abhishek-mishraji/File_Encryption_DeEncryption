import java.io.File;
import java.nio.file.Files;

public class my_encDec {

    static void encFil(File fil, String pas)
            throws Exception { // if there is any exception throw that exception instead inn compuile error

        byte[] filByt = Files.readAllBytes(fil.toPath()); // Read all bytes of Selected file and store in byte type
                                                          // array
        int key = Integer.parseInt(pas); // convert string pass to Integer
        for (int i = 0; i < filByt.length; i++) { // Here we are encrpting Selected file.......Using XOR operation
            filByt[i] = (byte) (filByt[i] ^ key);
            System.out.print(filByt[i] + "#-");
        }
        Files.write(fil.toPath(), filByt); // write output of the XOR operation in same file
    }
}