import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args){
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        Path inputFile = Paths.get("problem1.txt");
        Path outputFile = Paths.get("unique_words.txt");

        try{
            duplicateRemover.remove(inputFile);
            duplicateRemover.write(outputFile);
        } catch(IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }

    }

}
