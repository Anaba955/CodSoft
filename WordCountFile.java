import java.util.*;
// import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCountFile {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        System.out.print("Enter file name: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        Scanner sc = new Scanner(new File(filename));
        while(sc.hasNextLine()){
            String[] words = sc.nextLine().split(" ");
            for(String word: words){
                if(wordFrequencies.containsKey(word)){
                    wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                } else {
                    wordFrequencies.put(word, 1);
                }
            }
        }
        sc.close();
        scanner.close();
        int unique=0;
        for(String word: wordFrequencies.keySet()){
            if(wordFrequencies.get(word) == 1)  unique++;
            System.out.println(word + ":" + wordFrequencies.get(word));
        }

        System.out.println("Total no.of words: " + wordFrequencies.size());
        System.out.println("Total no.of unique words: " + unique);
    }
}
