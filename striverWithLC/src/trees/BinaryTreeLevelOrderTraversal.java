package trees;

import java.util.*;

class Element{
    TreeNode node;
    int level;

    public Element(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }

}

public class BinaryTreeLevelOrderTraversal {
    // SC - O(n) + O(N) + O(N)
    // TC - O(N)

    public List<List<Integer>> levelOrder(TreeNode root) {
        // thought do level order traversal
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(root, 0));
        Element element  = null;

        while(!queue.isEmpty()){
            element = queue.poll();
            if(!hashMap.containsKey(element.level))
                hashMap.put(element.level, new ArrayList<>());
            hashMap.get(element.level).add(element.node.val);

            if(element.node.left != null){
                queue.add(new Element(element.node.left, element.level + 1));
            }

            if(element.node.right != null){
                queue.add(new Element(element.node.right, element.level + 1));
            }
        }

        for(int i=0; i<=element.level; i++)
            ans.add(hashMap.get(i));
        return ans;
    }

    // Approach 2
    // TC - O(N)
    // SC - O(N)
    public List<List<Integer>> levelOrderApproach2(TreeNode root) {
        // thought do level order traversal
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> sublist = new ArrayList<>();
            int size = queue.size();

            for(int i=0; i<size; i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                sublist.add(queue.poll().val);
            }

            ans.add(sublist);
        }

        return ans;
    }
}
