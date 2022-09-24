package trees.lcprobs;

import java.util.ArrayList;
import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    /**
     * Problem Lnk - https://www.interviewbit.com/problems/path-to-given-node/
     * Best Explanation Striver - https://www.youtube.com/watch?v=fmflMqVOC7k
     * Time, Space - O(n), O(n)
     */

    public class RootToNodePath {
        // NOTE: Approach if a node - z returns false from both left and right subtree, it means x doesn;t exists there. Pop the node z.
        public Boolean pathToNode(TreeNode node, ArrayList<Integer> path, int x){
            if(node == null)
                return false;

            path.add(node.val);
            if(node.val == x)
                return true;

            Boolean flag1 = pathToNode(node.left, path, x);
            Boolean flag2 = pathToNode(node.right, path, x);

            // if both flags are false.
            if (flag1 == false && flag2 == false){
                // NOTE: for remove() time complexity for remove last element if - O(1)
                // for any other index it is O(n)
                path.remove(path.size() - 1);
                return false;
            }

            return true;
        }

        public ArrayList<Integer> solve(TreeNode A, int B) {
            ArrayList<Integer> path = new ArrayList<>();
            pathToNode(A, path, B);
            return path;
        }
    }
}

