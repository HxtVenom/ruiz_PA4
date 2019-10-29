import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class DuplicateRemover {
    private HashSet<String> uniqueWords = new HashSet<String>();

    public void remove (Path dataFile) {
        BufferedReader reader = null;
        Scanner fileScanner = null;
        PrintWriter fileOut;

        try {
            System.out.println("OPENING File: " + dataFile);
            reader = Files.newBufferedReader(dataFile);
            fileScanner = new Scanner(reader);

            String currWord;
            String editedText = "";

            //Checks for duplicate words and only adds unique words to edited file
            while (fileScanner.hasNext()) {
                currWord = fileScanner.next();

                if (!uniqueWords.contains(currWord)) {
                    uniqueWords.add(currWord);
                    editedText = editedText + " " + currWord;
                }
            }
            reader.close();

            //Print without duplicate words
            fileOut = new PrintWriter(dataFile.toString());
            fileOut.print(editedText);
            fileOut.close();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("CLOSING File: " + dataFile);
        }
    }

    public void write(Path outputFile){
        File file = new File(outputFile.toString());
        PrintWriter fileWrite = null;

        try{
            System.out.println("CREATING File: " + outputFile);
            file.createNewFile();

            System.out.println("OPENING File: " + outputFile);
            fileWrite = new PrintWriter(file);

            //Iterates through set of uniqueWords and prints to file
            for (Iterator<String> it = uniqueWords.iterator(); it.hasNext(); ) {
                String nextWord = it.next();
                fileWrite.println(nextWord);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally{
            System.out.println("CLOSING File: " + outputFile);
            fileWrite.close();
        }
    }
}
