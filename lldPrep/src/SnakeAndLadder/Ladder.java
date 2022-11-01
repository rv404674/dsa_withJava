package SnakeAndLadder;

import java.util.HashMap;

public class Ladder {
    private int start;
    private int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void updateLadderInGameBoard(HashMap<Integer, Ladder> ladderHashMap) {
        ladderHashMap.put(this.start, this);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
