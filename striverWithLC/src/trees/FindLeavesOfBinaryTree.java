package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// AC in one go.
// solved myself in 20mins.
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> path = new ArrayList<>();

        if(root == null){
            return path;
        }

        if(root.left == null && root.right == null){
            path.add(List.of(root.val));
            return path;
        }

        while(true){
            List<Integer> tempPath = new ArrayList<>();
            traverse(root, tempPath);
            path.add(tempPath);

            if (root.left == null && root.right == null) {
                path.add(List.of(root.val));
                break;
            }
        }

        return path;
    }

    public boolean traverse(TreeNode node, List<Integer> path){
        if(node == null)
            return false;

        if(node.left == null && node.right == null){
            path.add(node.val);
            return true;
        }

        boolean left = traverse(node.left, path);
        boolean right = traverse(node.right, path);

        if(left == true){
            node.left = null;
        }

        if(right == true){
            node.right = null;
        }

        return false;
    }


}
