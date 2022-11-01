package SnakeAndLadder;

import java.util.Random;

public class Dice {
    public static int getDiceRoll(){
        Random random = new Random();
        // nextInt - [0,6)
        int x = random.nextInt(6) + 1;
        return x;
    }
}
