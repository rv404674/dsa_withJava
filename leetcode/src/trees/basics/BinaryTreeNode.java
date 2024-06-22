package trees.basics;

/**
 * A Binary Tree has max 2 Nodes (0,1,2)
 * PreOrder Traversal - NLR (first node, then visit left node and then right)
 * InOrder - LNR
 * PostOrder - LRN
 * for a BT - insert/delete/find - O(N)
 */
public class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    BinaryTreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
