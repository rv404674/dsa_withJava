package graphs.dfsPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

/**
 * NOTE: DFS can also be used here.
 * as dfs will go from top-bottom and left-right, which is asked in the question.
 *
 * FIXME: Nopes DFS wont work here.
 * Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
 *
 * for this DFS will give wrong answer.
 */

public class BinaryTreeVerticalOrderTraversal {
    int minLevel = 0;
    int maxLevel = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        dfs(hashMap, root, 0);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = minLevel; i<=maxLevel; i++)
        {
            result.add(hashMap.get(i));
        }

        return result;
    }

    void dfs(HashMap<Integer, List<Integer>> hashMap, TreeNode root, int curLevel){
        if (root == null)
            return;

        minLevel = Math.min(curLevel, minLevel);
        maxLevel = Math.max(curLevel, maxLevel);

        if(!hashMap.containsKey(curLevel))
            hashMap.put(curLevel, new ArrayList<>());
        hashMap.get(curLevel).add(root.val);


        dfs(hashMap, root.left, curLevel -1);
        dfs(hashMap, root.right, curLevel+1);
    }


    }
