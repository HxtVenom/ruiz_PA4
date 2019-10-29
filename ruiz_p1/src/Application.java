import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args){
        DuplicateRemover remover = new DuplicateRemover();
        Path inputFile = Paths.get("problem1.txt");
        Path outputFile = Paths.get("unique_words.txt");

        remover.remove(inputFile);

        remover.write(outputFile);

    }

}
