package SnakeAndLadder;

import java.util.HashMap;

public class Snake {
    private int head;
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public void updateSnakesInGameBoard(HashMap<Integer, Snake> snakeHashMap){
        snakeHashMap.put(this.head, this);
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
