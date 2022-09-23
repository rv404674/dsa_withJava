package trees;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
    
public class LcaBt {
    public static void traverseInorderlyWay(TreeNode root, List<TreeNode> path, TreeNode x) {
        // traverse inorder
        if(root == x)
            return;

        if(root != null){
            path.add(root);
            traverseInorderlyWay(root.left, path, x);
            traverseInorderlyWay(root.right, path, x);
        }
    }

    /**
     * Wrote Myself
     * time - 3*O(n)
     * space - 2*O(n)
     */
    public static TreeNode lowestCommonAncestorAppr1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        traverseInorderlyWay(root, list1, p);

        List<TreeNode> list2 = new ArrayList<>();
        traverseInorderlyWay(root, list2, q);

        TreeNode ans = null;
        if(list1.size() < list2.size()){
            for(int i=0; i<list1.size(); i++){
                if (list1.get(i).val == list2.get(i).val)
                    ans = list1.get(i);
            }
        } else {
            for(int i=0; i<list2.size(); i++){
                if (list2.get(i).val == list1.get(i).val)
                    ans = list2.get(i);
            }
        }

        return ans;
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