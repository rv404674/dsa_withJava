package trees.lcprobs;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class VerticalOrderTraversalBt {

    /**
     * Approach - Use BFS (level order traversal as it will automatically take care of nodes - requirement from left to right).
     * need to use hashmap as well, for storing nodes at various levels.
     * top-bottom and left-right,
     *
     * Time - O(n) + k, space - 3*O(n)
     */

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root==null)
            return ans;

        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        Queue <TreeNode> queue = new LinkedList<>();
        // to keep track of levels
        Queue <Integer> levels = new LinkedList<>();

        queue.add(root);
        levels.add(0);

        // Cant use MAX_VAL, MIN_VAL here.
        // Use 0 instead
        // MIn max will fail for [1]
        int min = 0;
        int max = 0;

        while(!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            int curLevel = levels.poll();

            if (!hashMap.containsKey(curLevel))
                hashMap.put(curLevel, new ArrayList<Integer>());

            hashMap.get(curLevel).add(curNode.val);

            if (curNode.left != null) {
                queue.add(curNode.left);
                levels.add(curLevel - 1);
                min = min(min, curLevel - 1);
            }

            if (curNode.right != null) {
                queue.add(curNode.right);
                levels.add(curLevel + 1);
                max = max(max, curLevel + 1);
            }
        }

        for(int i=min; i<=max; i++){
            ans.add(hashMap.get(i));
        }

        return ans;

    }
}
