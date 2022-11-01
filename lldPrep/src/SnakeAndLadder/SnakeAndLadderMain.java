package SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderMain {
    public static void main(String[] args) {
        // Use a hasmap to give snakes position for an index
        HashMap<Integer, Snake> snakeHashMap = new HashMap<>();

        // use a hashmap to give ladders on that index
        HashMap<Integer, Ladder> ladderHashMap = new HashMap<>();

        // as a db to read and write
        List<Player> playerList = new ArrayList<>();


        // number of snakes.
        // 9
        // 62 5
        // 62 is head, 5 is tail
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        int snakes = scanner.nextInt();
        for(int i=1; i<=snakes; i++){
            String input = scanner.next();
            String[] tags = input.split(" ");
            int head = Integer.parseInt(tags[0]);
            int tail = Integer.parseInt(tags[1]);

            Snake snake = new Snake(head,tail);
            snake.updateSnakesInGameBoard(snakeHashMap);
        }

        // FIXME: refactor it later. same input code.
        // 8
        // 2 37
        // startPos End Pos
        int ladders = scanner.nextInt();
        for(int i=1; i<=ladders; i++){
            String input = scanner.next();
            String[] tags = input.split(" ");
            int start = Integer.parseInt(tags[0]);
            int end = Integer.parseInt(tags[1]);

            Ladder ladder = new Ladder(start, end);
            ladder.updateLadderInGameBoard(ladderHashMap);
        }

        // 2
        // Gaurav
        // Sagar
        int players = scanner.nextInt();
        for(int i=1; i<=players; i++){
            String name = scanner.next();
            Player player = new Player(name);
            player.savePlayers(playerList);
        }

        GameBoard gameBoard = GameBoard.getInstance(snakes, ladders, players);
        GameBoardService.startGamePlay(
                snakeHashMap,
                ladderHashMap, playerList, gameBoard
        );

    }

}
