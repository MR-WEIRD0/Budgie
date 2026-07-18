
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {


    public static void main(String[] args) throws IOException {

        if (args[0] == null) new Error("Missing Command");

        String command = args[0];

        switch (command) {
            case "build", "compile" -> {

                if (args[1] == null) new Error("File Not Found");

                String arg2 = args[1];

                if (!arg2.endsWith(".budge") && !arg2.endsWith(".bdge") && !arg2.endsWith(".bdg") && !arg2.endsWith(".🦜")) {
                    String[] message = {"Unrecognized File Type\n", "Supported file types:", ".budge", ".bdge", ".bdg"};
                    new Error(message);
                }

                Compiler compiler = new Compiler();
                Tokenizer tokenizer = new Tokenizer();

                Path path = Path.of(arg2);
       
                String file = Files.readString(path);

                String name = path.getFileName().toString();

                int dotPos = name.lastIndexOf('.');

                if (dotPos != -1) {
                    name = name.substring(0, dotPos);
                }

                compiler.compile(tokenizer.tokenize(file), name);

            }

            case "run" -> {

                if (args[1] == null) new Error("File Not Found");

                String arg2 = args[1];

                if (!arg2.endsWith(".bdgbin") && !arg2.endsWith(".bbin") && !arg2.endsWith(".bb")) {
                    String[] message = {"Unrecognized File Type\n", "Supported file types:", ".bdgbin", ".bbin", ".bb"};
                    new Error(message);
                }

                Path path = Path.of(arg2);

                Run run = new Run();

                run.runByte(path.toString());

            }

            default -> {
                new Error("Unknown Command");
            }

        }
        
    }
}