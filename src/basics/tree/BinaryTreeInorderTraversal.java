package basics.tree;

import java.util.ArrayList;
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

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        inOrder(root, path);
        return path;
    }

    public void inOrder(TreeNode root, List<Integer> path){
        if(root != null){
            inOrder(root.left, path);
            path.add(root.val);
            inOrder(root.right, path);
        }
    }
}
