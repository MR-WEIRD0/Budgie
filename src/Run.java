import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Run {
    static InputStream input;

    public static void main(String[] args) throws IOException {
       
        input = new BufferedInputStream(new FileInputStream(args[0]));

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
                                System.out.print((char) (file[i + j] & 0xFF));
                            }
                            i += length - 1;
                        }
                    }

                }
            }
        }
    }
}
