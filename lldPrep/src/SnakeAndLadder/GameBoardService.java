package SnakeAndLadder;

import java.util.HashMap;
import java.util.List;

public class GameBoardService {
    // FIXME: wrote the code in the better way
    // in java use constructor to do stuff.

    Dice dice;
    List<Player> playerList;
    HashMap<Integer, Ladder> ladderHashMap;
    HashMap<Integer, Snake> snakeHashMap;
    GameBoard gameBoard;
    Player winner;

    public GameBoardService(int diceNumber, int snakes, int ladders, List<Player> playerList, HashMap<Integer, Ladder> ladderHashMap, HashMap<Integer, Snake> snakeHashMap) {
        this.dice = new Dice(diceNumber);
        this.playerList = playerList;
        this.ladderHashMap = ladderHashMap;
        this.snakeHashMap = snakeHashMap;
        this.gameBoard = GameBoard.getInstance(snakes, ladders, playerList.size());
    }

    public void startGamePlay() {
        // read each player 1 by 1 from the hashMap
        // call Process(),
        // get the finalPos
        // print
        // if finalPos == 1
        // stop and print winnin message
        // update the hashMap

        while (winner == null) {
            for (int i=0; i<playerList.size(); i++) {
                Player player = playerList.get(i);
                int finalPosition = movePlayer(player);
                if (finalPosition == gameBoard.getWinningPosition()) {
                    System.out.println(player.getName() + " wins the game");
                    winner = player;
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
    public int movePlayer(Player player) {
        int diceRoll = dice.getDiceRoll();
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
        if(newPos == -1)
            newPos = player.curPos;

        System.out.printf("%s rolled a %s and moved from %s to %s\n", player.getName(), diceRoll, player.curPos, newPos);

//        stringBuilder.append(player.getName())
//                .append(" rolled a ")
//                .append(diceRoll)
//                .append(" and moved from ")
//                .append(player.curPos)
//                .append(" to ")
//                .append(newPos);
//        System.out.println(stringBuilder);
        return newPos;
    }
}
