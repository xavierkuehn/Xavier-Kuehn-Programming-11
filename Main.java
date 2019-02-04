import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){

        //initializes scanner which will receive input from the user
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //explains to user instructions on how to play
        System.out.println("Choose rock, paper or scissors. 'r' for rock, 'p' for paper and 's' for scissors.");

        //sets the 'playerChoice' variable to the users next input
        String playerChoice = scanner.next().toLowerCase();

        //creates a random integer: 0, 1 or 2, then adds 1 to that number. compInt can equal 1, 2 or 3.
        int compInt = random.nextInt(3) + 1;

        //sets the compChoice and choice variable as an empty string
        String compChoice = "";
        String choice = "";

        //set compChoice variable to rock, paper or scissors, depending on the value of compInt(1,2,3)
        if(compInt == 1){
            compChoice = "r";
            choice = "rock";
        } else if (compInt == 2){
            compChoice = "s";
            choice = "scissors";
        } else if (compInt == 3){
            compChoice = "p";
            choice = "paper";
        }

        //check to compare playerChoice to compChoice and decide winner
        if (compChoice.equals("p")){ // if computer chooses paper
            if (playerChoice.equals("p")) { //if player chooses paper
                System.out.println("Draw!");
                System.out.println("Computer chose paper, you chose paper.");
            } else if (playerChoice.equals("r")){ //if player chooses rock
                System.out.println("You lose!");
                System.out.println("Computer chose paper, you chose rock.");
            } else if (playerChoice.equals("s")){ //if player chooses scissors
                System.out.println("You win!");
                System.out.println("Computer chose paper, you chose scissors.");
            } else {
                System.out.println("Invalid user input, please play again."); //if user input is invalid, game will end
            }

        } else if (compChoice.equals("r")){ //if computer chooses rock
            if (playerChoice.equals("p")){ //if player chooses paper
                System.out.println("You win!");
                System.out.println("Computer chose rock, you chose paper.");
            } else if (playerChoice.equals("r")){ //if player chooses rock
                System.out.println("Draw!");
                System.out.println("Computer chose rock, you chose rock.");
            } else if (playerChoice.equals("s")){ //if player chooses scissors
                System.out.println("You lose!");
                System.out.println("Computer chose rock, you chose scissors.");
            } else {
                System.out.println("Invalid user input, please play again."); //if user input is invalid, game will end
            }

        } else if (compChoice.equals("s")){ //if computer chooses scissors
            if (playerChoice.equals("s")){ //if player chooses scissors
                System.out.println("Draw!");
                System.out.println("Computer chose scissors, you chose scissors.");
            } else if (playerChoice.equals("p")){ //if player chooses paper
                System.out.println("You lose!");
                System.out.println("Computer chose scissors, you chose paper.");
            } else if (playerChoice.equals("r")){ //if player chooses rock
                System.out.println("You win!");
                System.out.println("Computer chose scissors, you chose rock.");
            } else {
                System.out.println("Invalid user input, please play again."); //if user input is invalid, game will end
            }
        }
    }
}
