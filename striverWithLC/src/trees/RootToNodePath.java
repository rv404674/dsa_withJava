package trees;

import java.util.ArrayList;
import java.util.List;

//      * Problem Lnk - https://www.interviewbit.com/problems/path-to-given-node/

public class RootToNodePath {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> path = new ArrayList<>();
        traverse(A, B, path);
        return path;
    }

    public boolean traverse(TreeNode A, int b, ArrayList<Integer> path){
        // NOTE: use boolean approach
        // if the left subtree has b it will return true.
        // if both sides return false, it means that none of them has the node.
        if(A == null)
            return false;

        path.add(A.val);
        if(A.val == b)
            return true;

        boolean left = traverse(A.left, b, path);
        boolean right = traverse(A.right, b, path);

        if(left == false && right == false){
            // O(1) deletion for end
            path.remove(path.size() - 1);
            return false;
        }

        return true;

    }
}
