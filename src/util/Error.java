package util;

public class Error {
    public Error(String[] text) {
        StringBuilder error = new StringBuilder();

        for (String err : text) {
            error.append(err);
            error.append("\n");
        }

        IO.print(error.toString());
        System.exit(1);
    }

    public Error(String text) {
        IO.print(text);
        System.exit(1);
    }
}
