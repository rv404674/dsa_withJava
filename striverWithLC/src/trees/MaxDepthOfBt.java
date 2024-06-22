package trees;

public class MaxDepthOfBt {
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    public int getDepth(TreeNode root){
        if(root == null)
            return 0;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
