import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

    private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(Path dataFile) throws IOException {
        File file = new File(dataFile.toString());
        FileInputStream fileInputStream = null;

        String currWord;

        try{

            if(!file.exists()){
                throw new Exception("ERROR: File does not exist.");
            }

            System.out.println("OPENING File: " + dataFile);
            fileInputStream = new FileInputStream(file);
            Scanner fileScanner = new Scanner(fileInputStream);

            while(fileScanner.hasNext()){
                currWord = fileScanner.next();
                if(!wordCounter.containsKey(currWord)){
                    wordCounter.put(currWord, 1);
                }else{
                    int x = wordCounter.get(currWord);
                    x++;
                    wordCounter.put(currWord, x);
                }
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally{
            System.out.println("CLOSING File: " + dataFile);
            fileInputStream.close();
        }
    }


    public void write(Path outputFile) throws IOException {
        File file = new File(outputFile.toString());
        FileOutputStream fileOutput = null;
        PrintWriter fileWrite = null;

        try {
            System.out.println("CREATING File: " + outputFile);
            file.createNewFile();

            System.out.println("OPENING File: " + outputFile);
            fileOutput = new FileOutputStream(file);
            fileWrite = new PrintWriter(fileOutput);

            fileWrite.printf("\t\tCounts by Word\n");
            fileWrite.println("-------------------------------");

            for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
                fileWrite.printf("%-15s|%15d\n", entry.getKey(), entry.getValue());
            }

            fileWrite.flush(); //FLUSH WRITER

        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("CLOSING File: " + outputFile);
            fileOutput.close();
            fileWrite.close();
        }
    }
}
