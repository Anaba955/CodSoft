import java.util.*;

public class NumberGame{

    public static int newGame(int random, int Maxattempts){
        Scanner sc = new Scanner(System.in);
        int attempts = Maxattempts;
        while(attempts > 0){
            System.out.println("Guess the number (between 1 and 100):");
            int user = sc.nextInt();
            if(user == random){
                System.out.println("You guessed it right!");
                System.out.println("You took " + (Maxattempts - attempts) + " tries!");
                break;
            } else if(user < random){
                System.out.println("Number is too low!");
            } else {
                System.out.println("Number is too high!");
            }
            System.out.println("Attempts left: " + --attempts);
        }
        if(attempts == 0){
            System.out.println("You ran out of attempts!. The correct number was: " + random);
        }
        return Maxattempts - attempts;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        int rounds = 0;
        int totalAttempts = 0;
        while(choice == 1){
            Random random = new Random();
            int randNum = random.nextInt(100) + 1;
            totalAttempts += newGame(randNum, 10);
            rounds++;

            System.out.println("Enter your choice:");
            System.out.println("1. Play \n2. Exit");
            choice = sc.nextInt();
        }
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Total Attempts: " + totalAttempts);
        sc.close();
    }
}
