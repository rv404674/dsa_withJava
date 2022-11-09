package basics.tree;

import java.util.*;

class Element {
    TreeNode treeNode;
    int level;

    public Element(TreeNode treeNode, int level) {
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

        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(root, 0));
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            Element element = queue.poll();
            if(!hashMap.containsKey(element.level))
                hashMap.put(element.level, new ArrayList<>());

            hashMap.get(element.level).add(element.treeNode.val);
            mn = Math.min(mn, element.level);
            mx = Math.max(mx, element.level);

            if(element.treeNode.left != null){
                queue.add(new Element(element.treeNode.left, element.level-1));
            }

            if(element.treeNode.right != null){
                queue.add(new Element(element.treeNode.right, element.level+1));
            }
        }

        for(int i = mn; i<=mx; i++)
            ans.add(hashMap.get(i));

        return ans;

    }
}
