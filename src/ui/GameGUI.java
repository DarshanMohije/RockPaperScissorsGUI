package ui;

import model.Choice;
import logic.ComputerChoice;
import logic.GameLogic;
import logic.Scoreboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener {

    private JLabel userChoiceLabel, computerChoiceLabel, resultLabel, scoreLabel;
    private Scoreboard scoreboard;

    public GameGUI() {
        setTitle("Rock Paper Scissors Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        scoreboard = new Scoreboard();

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton rockBtn = new JButton("Rock");
        JButton paperBtn = new JButton("Paper");
        JButton scissorsBtn = new JButton("Scissors");

        rockBtn.addActionListener(this);
        paperBtn.addActionListener(this);
        scissorsBtn.addActionListener(this);

        buttonPanel.add(rockBtn);
        buttonPanel.add(paperBtn);
        buttonPanel.add(scissorsBtn);
        add(buttonPanel);

        // Labels
        userChoiceLabel = new JLabel("You chose: ");
        computerChoiceLabel = new JLabel("Computer chose: ");
        resultLabel = new JLabel("Result: ");
        scoreLabel = new JLabel("Wins: 0  Losses: 0  Draws: 0");

        add(userChoiceLabel);
        add(computerChoiceLabel);
        add(resultLabel);
        add(scoreLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = e.getActionCommand().toUpperCase();
        Choice userChoice = Choice.valueOf(userInput);
        Choice computerChoice = ComputerChoice.getComputerChoice();

        userChoiceLabel.setText("You chose: " + userChoice);
        computerChoiceLabel.setText("Computer chose: " + computerChoice);

        String result = GameLogic.getResult(userChoice, computerChoice);
        resultLabel.setText("Result: " + result);

        scoreboard.recordResults(result);
        updateScoreboard();
    }

    private void updateScoreboard() {
        scoreLabel.setText("Wins: " + scoreboard.getWins()
                + "  Losses: " + scoreboard.getLosses()
                + "  Draws: " + scoreboard.getDraws());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameGUI().setVisible(true);
        });
    }
}
