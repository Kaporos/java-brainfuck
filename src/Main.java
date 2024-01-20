import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("noloop.bf");
        Scanner reader = new Scanner(f);
        String content = "";
        while (reader.hasNext()) {
            content += reader.next(); //reading all lines and concatenating them.
        }
        FuckingInterpreter i = new FuckingInterpreter(content);
        i.execute();

    }
}