import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args){
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        Path dataFile  = Paths.get("problem2.txt");
        Path outputFile  = Paths.get("unique_word_counts.txt");

        try {
            duplicateCounter.count(dataFile);
            duplicateCounter.write(outputFile);
        }catch(IOException e){
            System.out.println("ERROR: " e.getMessage());
        }
    }
}
