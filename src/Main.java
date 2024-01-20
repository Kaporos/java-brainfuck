import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filename;
        if (args.length == 0) {
            filename = "main.bf";
        } else {
            filename = args[0];
        }
        File f = new File(filename);
        Scanner reader = new Scanner(f);
        String content = "";
        while (reader.hasNext()) {
            content += reader.next(); //reading all lines and concatenating them.
        }
        FuckingInterpreter interpreter = new FuckingInterpreter();
        interpreter.execute(content);
    }
}