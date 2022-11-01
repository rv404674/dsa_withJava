package SnakeAndLadder;

import java.util.HashMap;
import java.util.List;

public class GameBoardService {
    public static void startGamePlay(HashMap<Integer, Snake> snakeHashMap, HashMap<Integer, Ladder> ladderHashMap, List<Player> playerList, GameBoard gameBoard) {
        // read each player 1 by 1 from the hashMap
        // call Process(),
        // get the finalPos
        // print
        // if finalPos == 1
        // stop and print winnin message
        // update the hashMap

        Boolean flag = false;
        while (!flag) {
            for (int i=0; i<playerList.size(); i++) {
                Player player = playerList.get(i);
                int finalPosition = movePlayer(player, snakeHashMap, ladderHashMap, gameBoard);
                if (finalPosition == gameBoard.getWinningPosition()) {
                    System.out.println(player.getName() + " wins the game");
                    flag = true;
                    break;
                }

                // if, no update the list with new position
                player.setCurPos(finalPosition);
                playerList.set(i, player);
            }
        }
    }

    /**
     * Get diceRollNum
     * get the newPos
     * if newPos > sizeOfGameBoard
     * return -1
     * check for snakes or ladder on newPos
     * if snake or ladder
     * process accordingly
     * return newPos
     * @return newPos
     */
    public static int movePlayer(Player player, HashMap<Integer, Snake> snakeHashMap, HashMap<Integer, Ladder> ladderHashMap, GameBoard gameBoard) {
        int diceRoll = Dice.getDiceRoll();
        int newPos = player.curPos + diceRoll;

        if (newPos > gameBoard.getSize()) {
            newPos = -1;
        } else if (snakeHashMap.containsKey(newPos)) {
            // check for snake
            newPos = snakeHashMap.get(newPos).getTail();
        } else if (ladderHashMap.containsKey(newPos)) {
            // check for ladders
            newPos = ladderHashMap.get(newPos).getEnd();
        }

        // Gaurav rolled a 6 and moved from 0 to 6
        StringBuilder stringBuilder = new StringBuilder();
        if(newPos == -1)
            newPos = player.curPos;

        stringBuilder.append(player.getName())
                .append(" rolled a ")
                .append(diceRoll)
                .append(" and moved from ")
                .append(player.curPos)
                .append(" to ")
                .append(newPos);
        System.out.println(stringBuilder);

        return newPos;
    }
}
