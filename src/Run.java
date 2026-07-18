import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import util.Opcodes;

public class Run {
    static InputStream input;

    public static void runByte(String fileName) throws IOException {
       
        input = new BufferedInputStream(new FileInputStream(fileName));

        byte[] file = input.readAllBytes();

        for (int i = 0; i < file.length; i++) {
            switch (file[i] & 0xFF) {
                case Opcodes.PRINT -> {
                    i++;
                    switch (file[i] & 0xFF) {
                        case Opcodes.STRING -> {
                            i++;
                            int length = file[i] & 0xFF;
                            i++;
                            for (int j = 0; j < length; j++) {
                                IO.print((char) (file[i + j] & 0xFF));
                            }
                            i += length - 1;
                        }
                    }

                }
            }
        }
    }
}
