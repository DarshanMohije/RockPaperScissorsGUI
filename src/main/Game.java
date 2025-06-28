package main;

import model.Choice;
import logic.ComputerChoice;
import logic.GameLogic;
import logic.Scoreboard;
import utils.InputHandler;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scoreboard scoreboard = new Scoreboard();
        
        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            Choice userChoice = InputHandler.getUserChoice();
            Choice computerChoice = ComputerChoice.getComputerChoice();

            System.out.println("Computer chose: " + computerChoice);
            
            String result = GameLogic.getResult(userChoice, computerChoice);
            System.out.println(result);
            
            scoreboard.recordResults(result);
            scoreboard.showScore();

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.nextLine().trim().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing!");
                
                System.out.println("Final score:");
                scoreboard.showScore();
                break;
            }
        }

        sc.close();
    }
}
