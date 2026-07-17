
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        Compiler compiler = new Compiler();
        Tokenizer tokenizer = new Tokenizer();

        Path path = Path.of(args[0]);
       
        String file = Files.readString(path);

        String name = path.getFileName().toString();

        int dotPos = name.lastIndexOf('.');

        if (dotPos != -1) {
            name = name.substring(0, dotPos);
        }

        compiler.compile(tokenizer.tokenize(file), name);
        
    }
}


/*
⠀⠀⠀⠀⠀⠀⢀⡞⠹⣦⠰⡞⠙⣆⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⢴⠀⠀⣿⠐⡇⠀⢻⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⢸⠀⠀⣿⢸⡇⠀⢸⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢀⡸⣄⠀⣿⣨⡇⠀⣟⡀⠀⠀⠀⠀⠀
⠀⠀⢠⡶⠚⠉⢁⡀⠀⠀⠀⠀⠀⡈⠉⠙⠲⣤⡀⠀
⢀⡶⠋⠀⢀⠔⠉⠀⠀⠀⠀⠀⠀⠈⠑⢄⠀⠈⠻⡄
⣾⠁⠀⠀⠈⠀⣠⣂⡄⠀⠀⠀⣔⣢⠀⠈⠀⠀⠀⢹
⡇⠀⠀⢠⣠⣠⡌⠓⠁⠀⡀⠀⠙⠊⡄⢀⣀⠀⠀⢸        Usagi is watching you
⢷⡀⠀⠈⠁⠁⠀⠀⠈⠓⡓⠂⠀⠀⠉⠈⠁⠀⠀⡼        look through the files
⠈⠳⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡞⠁
⠀⠀⢾⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⢸⠀⠀
⠀⠀⠈⢻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡾⠊⠁⠀
⠀⠀⠀⠘⣇⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⡀⣷⠀⠀⠀
⠀⠀⠀⠀⢿⣼⠉⠉⠙⠛⠛⠛⠛⠉⢹⣁⠟⠀⠀⠀
*/