package trees.lcprobs;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
    
public class LcaOfABt {
    /**
     * Apprach1 - Find path to both and nodes and then it is easy.
     * time - 3*O(n)
     * space - 2*O(n)
     */

    public static Boolean findPathToNode(TreeNode node, ArrayList<TreeNode> path, int x) {
        if(node == null)
            return false;

        path.add(node);
        if(node.val == x)
            return true;

        boolean flag1 = findPathToNode(node.left, path, x);
        boolean flag2 = findPathToNode(node.right, path, x);

        if (flag1 == false && flag2 == false){
            // NOTE: for remove() time complexity for remove last element if - O(1)
            // for any other index it is O(n)
            path.remove(path.size() - 1);
            return false;
        }

        return true;
    }
    
    public static TreeNode lowestCommonAncestorAppr1(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        findPathToNode(root, path1, p.val);

        ArrayList<TreeNode> path2 = new ArrayList<>();
        findPathToNode(root, path2, q.val);

        TreeNode ans = null;
        if(path1.size() < path2.size()){
            for(int i=0; i<path1.size(); i++){
                if(path1.get(i).val == path2.get(i).val)
                    ans = path1.get(i);
            }
        } else {
            for (int i = 0; i < path2.size(); i++) {
                if (path2.get(i).val == path1.get(i).val)
                    ans = path2.get(i);
            }
        }

        return ans;
    }

    /**
     * NOTE: Most optimized - O(n), O(1)
     * Striver - https://www.youtube.com/watch?v=_-QHfMDde90&t=17s
     * Approach - difficult to write here see the video.
     */
    public static TreeNode lowestCommonAncestorAppr(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestorAppr(root.left, p,q);
        TreeNode right = lowestCommonAncestorAppr(root.right, p,q);

        if (left == null) {
            return right;
        } else if (right == null){
            return left;
        } else if (left == null && right == null) {
            return null;
        } else {
            // NOTE: you have found your lca, as both left and right is not null
            return root;
        }

    }



    public static void main(String[] args) {
        TreeNode c1 = new TreeNode(1);
        TreeNode c2 = new TreeNode(2);
        TreeNode c3 = new TreeNode(3);
        TreeNode c4 = new TreeNode(4);
        TreeNode c5 = new TreeNode(5);
        TreeNode c6 = new TreeNode(6);
        TreeNode c7 = new TreeNode(7);

        c1.left = c2;
        c1.right = c3;
        c2.left  = c4;
        c2.right = c5;
        c3.left = c6;
        c3.right = c7;

        System.out.println(lowestCommonAncestorAppr1(c1, c5, c6).val);


    }
}