package trees.basics;

/**
 * NOTE: For a BST, all the elements in the left sub tree SHOULD BE SMALLER then root node and
 * all the elements in right sub tree should be GREAETER then root node.
 *
 * an in order traversal would give a SORTED output.
 * NOTE: for a bst insert/delete/search - O(logn) average
 * for skewed trees - O(N) in worst.
 *
 * https://www.softwaretestinghelp.com/binary-search-tree-in-java/
 */

public class BSTClass {
    BinaryTreeNode root;

    BSTClass(){
        this.root = null;
    }

    // TODO: implement delete as well.

    // search for a node
    public boolean searchKey(BinaryTreeNode node, int x){
        if(searchKeyRecursive(node, x) != null) {
            return true;
        } else {
            return false;
        }
    }

    public BinaryTreeNode searchKeyRecursive(BinaryTreeNode node, int x) {
        if (node == null || node.data == x){
            return node;
        }

        if(x > node.data){
            return searchKeyRecursive(node.right, x);
        } else {
            return searchKeyRecursive(node.left, x);
        }
    }

    // insert a node
    public void insertNode(int x){
        root = insertNodeRecursive(root, x);
    }

    public BinaryTreeNode insertNodeRecursive(BinaryTreeNode root, int x) {
        // Tree is empty
        if(root == null) {
            root = new BinaryTreeNode(x);
            return root;
        }

        if (x < root.data){
            root.left = insertNodeRecursive(root.left, x);
        } else {
            root.right = insertNodeRecursive(root.right, x);
        }

        return root;
    }

    public void inorderTraversal(BinaryTreeNode node){
        if (node != null){
            // LNR
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args){
        BSTClass bstClass = new BSTClass();
        bstClass.insertNode(45);
        bstClass.insertNode(10);
        bstClass.insertNode(7);
        bstClass.insertNode(90);
        bstClass.insertNode(12);
        bstClass.insertNode(50);
        bstClass.insertNode(13);
        bstClass.insertNode(39);
        bstClass.insertNode(57);

        bstClass.inorderTraversal(bstClass.root);
    }
}
