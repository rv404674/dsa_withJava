package Chapter2MeaningfulNames;

import java.util.ArrayList;
import java.util.List;

/**
 * NOTE: Basics
 * 1. Name should reveal intent.
 * 2. Somebody else would be reading your code, make it easy for them to read.
 */
public class IntentionRevealingBasics {
    public void variableNames() {
        // FIXME:
        int d; // elapsed time in days;

        int elapsedTimeInDays;
        int daysPassed;
        int daysSinceCreation;
    }

    public List<int[]> getThem(){
        List<int[]> list1 = new ArrayList<>();
        for (int x[]: theList){
            if (x[0] == 4)
                list1.add(x);
        }

        return list1;
    }

    // Assum - minesweeper game.
    // 4 means a flagged cell
    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<>();
        for(int[] cell : gameBoard){
            if(cell[STATUS_VALUE] == Constants.FLAGGED)
                flaggedCells.add(cell);
        };

        return flaggedCells;
    }
}
