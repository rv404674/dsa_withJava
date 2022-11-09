package basics.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfaBt {

    // NOTE: Approach 1
    // Striver use Recursive appraoch - https://www.youtube.com/watch?v=KV4mRzTjlAk
    // Easy to understand code
    // n - number of nodes
    // TC - O(N), space - O(N) (stack space) + O(k)
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        // OBSERVE THE PATTERN
        recursiveTraverse(root, ans, 0);
        return ans;
    }

    public void recursiveTraverse(TreeNode root, List<Integer> ans, int level) {
        if (root != null) {
            // NRL
            if (ans.size() == level)
                ans.add(root.val);
            recursiveTraverse(root.right, ans, level + 1);
            recursiveTraverse(root.left, ans, level + 1);
        }
    }

    // NOTE: Approach 2
    // Iterative
    // Use Level Order Traversal. Write simple code
    public List<Integer> rightSideViewIterative(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = null;
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            ans.add(node.val);
        }
        return ans;
    }
}
