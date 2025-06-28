package logic;

import model.Choice;

public class GameLogic {
	public static String getResult(Choice userChoice, Choice computerChoice) {
		if (userChoice == computerChoice) {
			return "It's a draw";
		}
		switch (userChoice) {
		case ROCK:
			return (computerChoice == Choice.SCISSORS) ? "You win!":"You lose!";
			
		case PAPER:
			return (computerChoice == Choice.ROCK) ? "You win!":"You lose!";
			
		case SCISSORS:
			return (computerChoice == Choice.PAPER) ? "You win!":"You lose!";
			
		default:
			return "Invalid choice!";
		}
	}
}
