package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 1){
            ans.add(new ArrayList<>(List.of(1)));
            return ans;
        } else if (numRows == 2) {
            ans.add(new ArrayList<>(List.of(1)));
            ans.add(new ArrayList<>(List.of(1,1)));

            return ans;
        }

        ans.add(new ArrayList<>(List.of(1)));
        ans.add(new ArrayList<>(List.of(1,1)));

        int curLen = 2;
        while(curLen <= numRows){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            List<Integer> prevList = ans.get(ans.size()-1);
            for(int i=1;i<prevList.size(); i++)
                tempList.add(prevList.get(i) + prevList.get(i-1));
            tempList.add(1);

            ans.add(tempList);
            curLen +=1;
        }

        return ans;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(6));
        // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1]]
    }
}
