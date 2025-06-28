package logic;

public class Scoreboard {
	private int wins = 0;
	private int losses = 0;
	private int draws = 0;
	
	public void recordResults(String result) {
		switch (result) {
		case "You win!":
			wins++;
			break;
		case "You lose!":
			losses++;
			break;
		case "It's a draw":
			draws++;
			break;
		}
	}
	public void showScore() {
		System.out.println("\n=== ScoreBoard ===");
		System.out.println("Wins: " + wins);
		System.out.println("Losses: " + losses);
		System.out.println("Draws: " + draws);
		System.out.println("Total games played: "+ (wins+losses+draws));
		System.out.println("=================================================\n");
	}
	
	public int getWins() { return wins; }
	public int getLosses() { return losses; }
	public int getDraws() { return draws; }

}
