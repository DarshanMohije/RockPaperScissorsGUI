package utils;

import java.util.Scanner;

import model.Choice;

public class InputHandler {
	public static Choice getUserChoice() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter your choice rock, paper or scissors: ");
		String input = sc.nextLine().trim().toUpperCase();
		
		try {
			return Choice.valueOf(input);
		} catch(IllegalArgumentException e){
			System.out.println("Inavlid Input! Try Again.");
			return getUserChoice();
		}
	}
}
