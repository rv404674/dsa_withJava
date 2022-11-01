package SnakeAndLadder;

public class GameBoard {
    private static GameBoard instance = null;
    private int size;
    private int winningPosition;
    private int snakes;
    private int ladders;
    private int players;

    public GameBoard(int size, int winningPosition, int snakes, int ladders, int players) {
        this.size = size;
        this.winningPosition = winningPosition;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
    }

    public static GameBoard getInstance(int snakes, int ladders, int players){
        if(instance == null){
            instance = new GameBoard(100, 100, snakes, ladders, players);
        }
        return instance;
    }

    public int getSize() {
        return size;
    }

    public int getWinningPosition() {
        return winningPosition;
    }
}
