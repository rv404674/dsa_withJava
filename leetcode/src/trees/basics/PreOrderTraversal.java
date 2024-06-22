package trees.basics;

public class PreOrderTraversal {

    // NLR
    // first traverse node then left and then right.
    public static void preOrderTraversal(BinaryTreeNode node){
        if (node != null){
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }


    }

    public static void main(String[] args){
        BinaryTreeNode c1 = new BinaryTreeNode(1);
        BinaryTreeNode c2 = new BinaryTreeNode(2);
        BinaryTreeNode c3 = new BinaryTreeNode(3);
        BinaryTreeNode c4 = new BinaryTreeNode(4);
        BinaryTreeNode c5 = new BinaryTreeNode(5);
        BinaryTreeNode c6 = new BinaryTreeNode(6);
        BinaryTreeNode c7 = new BinaryTreeNode(7);

        c1.left = c2;
        c1.right = c3;
        c2.left  = c4;
        c2.right = c5;
        c3.left = c6;
        c3.right = c7;
        preOrderTraversal(c1);

    }
}
