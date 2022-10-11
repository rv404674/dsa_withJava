package trees.lcprobs;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class StepByStepDirections {
    // Question - https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

    /**
     * Approach - the path from s to t will pass from LCA.
     * find path from lca to s = [R,L,R,R]
     * path from lca to t = [R,R,R]
     *
     * remove prefix from both and change list1 to U.
     * (from s to LCA it will be always U).
     * [U,U,U]
     * [R,R]
     * append both of these.
     *
     * NOTE: Edge case, when both nodes are in same subtree, in diff subtree.
     * Time - 3*O(n), Space - 3*O(n)
     */
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder ans = new StringBuilder();

        List<String> path1 = new ArrayList<>();
        List<String> path2 = new ArrayList<>();

        TreeNode lca = getLca(root, startValue, destValue);
        getPathToNode(lca, startValue, path1, "");
        getPathToNode(lca, destValue, path2, "");

        int x = 0;
        for (int i=0; i< min(path1.size(), path2.size()); i++){
            if(path1.get(i) == path2.get(i)) {
                x +=1;
            } else {
                break;
            }
        }

        for(int i=x; i<path1.size(); i++)
            ans.append("U");

        for(int i=x; i<path2.size(); i++)
            ans.append(path2.get(i));

        return ans.toString();
    }

    public Boolean getPathToNode(TreeNode node, int startValue, List<String> path, String side) {
        if (node == null)
            return false;

        path.add(side);
        if(node.val == startValue)
            return true;

        Boolean f1 = getPathToNode(node.left, startValue, path, "L");
        Boolean f2 = getPathToNode(node.right, startValue, path, "R");

        if(f1 == false && f2 == false) {
            path.remove(path.size() - 1);
            return false;
        }

        return true;

    }

    public TreeNode getLca(TreeNode node, int start, int dest){
        if(node == null)
            return null;

        if (node.val == start || node.val == dest)
            return node;

        TreeNode left = getLca(node.left, start, dest);
        TreeNode right = getLca(node.right, start, dest);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            // if both are not null, means the current node is LCA
            return node;
        }
    }

}
