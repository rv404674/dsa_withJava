package basics.tree;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Element {
    Node node;
    int level;

    public Element(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

// FIXME: SEE RIGHT VIEW code for two approaches.
public class LeftViewofABT {
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        if(root == null)
            return new ArrayList<>();

        // Your code here
        // ans would be first node on every level
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(root, 0));

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        int mxLevel = 0;
        while(!queue.isEmpty()){
            Element el = queue.poll();
            mxLevel = el.level;
            List<Integer> tmpList = hashMap.getOrDefault(el.level, new LinkedList<>());
            tmpList.add(el.node.data);
            hashMap.put(el.level, tmpList);

            if(el.node.left != null){
                queue.add(new Element(el.node.left, el.level+1));
            }

            if(el.node.right != null){
                queue.add(new Element(el.node.right, el.level+1));
            }

        }

        for(int i=0; i<=mxLevel; i++){
            ans.add(hashMap.get(i).get(0));
        }

        return ans;
    }
}



