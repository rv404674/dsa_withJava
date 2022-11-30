package trees;

import java.util.*;

// https://www.youtube.com/watch?v=i9ORlEy6EsI
// NOTE: Thought Process
// Definitely a hard level prob
// 1. we need to move up as well, so create parent pointers (node -> parent) - BFS traversal
// 2. once we have parent pointers, do a BFS with (left, right, parent) and keep on radially incrementing the distance.
// 3. once you reach till the distance, then stop the traversal, your answer is in the queue.


// NOTE: creating parent pointers can be used somewhere else as well. if you want to traverse upwareds.
// TC - 2*O(N)
// SC - 2 * O(N)

public class AllNodesDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> childToParentHashMap = new HashMap<>();
        setParentpointer(root, childToParentHashMap);

        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        int level = 0;
        queue.add(target);
        visited.add(target);


        // from target move radially left, right and up
        while(!queue.isEmpty()){
            int size = queue.size();
            if(level == k)
                break;
            level +=1;

            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                // left
                // NOTE: use visited else infinite traversal
                if(node.left != null && !visited.contains(node.left)){
                    queue.add(node.left);
                    visited.add(node.left);
                }

                // right
                if(node.right != null && !visited.contains(node.right)){
                    queue.add(node.right);
                    visited.add(node.right);
                }

                // parent
                if(childToParentHashMap.get(node) != null && !visited.contains(childToParentHashMap.get(node))){
                    queue.add(childToParentHashMap.get(node));
                    visited.add(childToParentHashMap.get(node));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty())
            ans.add(queue.poll().val);

        return ans;
    }

    public void setParentpointer(TreeNode root, HashMap<TreeNode, TreeNode> childToParentHashMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
                childToParentHashMap.put(node.left, node);
            }

            if(node.right != null){
                queue.add(node.right);
                childToParentHashMap.put(node.right, node);
            }
        }
    }
}
