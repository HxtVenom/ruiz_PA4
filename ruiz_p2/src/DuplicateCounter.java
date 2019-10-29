import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

    private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(Path dataFile) {
        File file = new File(dataFile.toString());
        String currWord;
        FileInputStream fileInputStream = null;

        try{

            if(!file.exists()){
                throw new Exception("ERROR: File does not exist.");
            }

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
            try {
                fileInputStream.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }


    public void write(Path outputFile) {
        File file = new File(outputFile.toString());
        FileOutputStream fileOutput = null;
        PrintWriter fileWrite = null;
        try {
            file.createNewFile();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        try {
            fileOutput = new FileOutputStream(file);
            fileWrite = new PrintWriter(fileOutput);

            fileWrite.printf("Counts by Word\n");

            for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
                fileWrite.printf("%-20s|%23d\n", entry.getKey(), entry.getValue());
            }

            fileWrite.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                fileOutput.close();
                fileWrite.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
