package SnakeAndLadder;

import java.util.Random;

public class Dice {
    // FIXME: Added, dices can be two in the future.
    private int numberOfDices;

    public Dice(int numberOfDices) {
        this.numberOfDices = numberOfDices;
    }

    public int getDiceRoll(){
        int totalValue = 0;
        for(int i=1; i<=numberOfDices; i++){
            Random random = new Random();
            // nextInt - [0,6)
            int x = random.nextInt(6) + 1;
            totalValue += x;
        }
        return totalValue;
    }
}
