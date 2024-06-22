package trees.lcprobs;

import java.util.HashSet;
import java.util.Set;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

/**
 * NOTE: Because there is parent pointer,
 * from p traverse till root and store the path in hashset.
 * From q traverse till root and find the occurance in haset. If yes, that is the answer.
 *
 * NOTE: given nodes are unique, p!=q and nodes exist in tree.
 * n is height of tree, not total nodes
 * Time, Space - O(n), O(n)
 */
public class LcaOfBt3 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> path = findPath(p);

        // traverse till root.
        while(q.parent != null) {
            if(path.contains(q))
                return q;

            q = q.parent;
        }

        return q;
    }

    public Set<Node> findPath(Node p) {
        Set<Node> path = new HashSet<>();

        // root's parent is null
        while(p.parent != null) {
            path.add(p);
            p = p.parent;
        }

        return path;
    }
}
