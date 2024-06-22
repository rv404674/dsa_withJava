package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// Saw this - https://www.youtube.com/watch?v=mQeF6bN8hMk
// NOTE: Though process - Keep the old node mapped to new node.
public class CloneGraph {
    public Node cloneGraph(Node node) {
        // old to new node mapping
        HashMap<Node, Node> hashMap = new HashMap<>();
        if(node == null)
            return null;

        return dfs(node, hashMap);
    }

    public Node dfs(Node node, HashMap<Node, Node> hashMap){
        if(hashMap.containsKey(node))
            return hashMap.get(node);

        Node copy = new Node(node.val);
        hashMap.put(node, copy);
        for(Node neighbour: node.neighbors){
            copy.neighbors.add(dfs(neighbour, hashMap));
        }

        return copy;
    }
}
