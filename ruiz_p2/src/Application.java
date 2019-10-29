import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args){
        DuplicateCounter words = new DuplicateCounter();
        String dir = System.getProperty("user.dir");
        Path dataFile  = Paths.get("problem2.txt");
        Path outputFile  = Paths.get("unique_word_counts.txt");

        words.count(dataFile);
        words.write(outputFile);
    }
}
