package basics.tree;

import java.util.*;

class Element2 {
    TreeNode treeNode;
    int level;

    public Element2(TreeNode treeNode, int level) {
        this.treeNode = treeNode;
        this.level = level;
    }
}


// https://leetcode.com/problems/binary-tree-vertical-order-traversal/
// TC - O(N) + O(k)
// SC - O(N) + O(k)
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        if(root == null)
            return ans;

        Queue<Element2> queue = new LinkedList<>();
        queue.add(new Element2(root, 0));
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            Element2 Element2 = queue.poll();
            if(!hashMap.containsKey(Element2.level))
                hashMap.put(Element2.level, new ArrayList<>());

            hashMap.get(Element2.level).add(Element2.treeNode.val);
            mn = Math.min(mn, Element2.level);
            mx = Math.max(mx, Element2.level);

            if(Element2.treeNode.left != null){
                queue.add(new Element2(Element2.treeNode.left, Element2.level-1));
            }

            if(Element2.treeNode.right != null){
                queue.add(new Element2(Element2.treeNode.right, Element2.level+1));
            }
        }

        for(int i = mn; i<=mx; i++)
            ans.add(hashMap.get(i));

        return ans;

    }
}
