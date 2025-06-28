package logic;

import model.Choice;
import java.util.Random;

public class ComputerChoice {
    public static Choice getComputerChoice() {
        Choice[] values = Choice.values();
        Random random = new Random();
        return values[random.nextInt(values.length)];
    }
}
