package top.aranlzh;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        left = null;
        right = null;
    }

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    TreeNode(int val,  TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }



    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}