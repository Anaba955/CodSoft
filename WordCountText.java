import java.util.*;

public class WordCount {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.print("Enter text:");
        String input = sc.nextLine();
        if(input == " "){
            System.out.println("Empty string!");
        }
        String delimiters[] = {" ", ",", "."};
        String arr[] = Arrays.stream(input.split(String.join(";", delimiters))).toArray(String[]::new);
        for(String s: arr){
            count++;
        }
        System.out.println("No.of words:" + (count+1));
        sc.close();
    }
}
