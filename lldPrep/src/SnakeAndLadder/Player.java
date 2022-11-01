package SnakeAndLadder;

import java.util.HashMap;
import java.util.List;

public class Player {
    private String name;
    int curPos = 0;


    public Player(String name) {
        this.name = name;
    }

    public void savePlayers(List<Player> playerHashMap){
        playerHashMap.add(this);
    }

    public String getName() {
        return name;
    }

    public void setCurPos(int curPos) {
        this.curPos = curPos;
    }
}
