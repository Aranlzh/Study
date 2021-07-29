package top.aranlzh;

public class Test2 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //递归反转左右子树
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode5, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        System.out.println(treeNode1);

        System.out.println(new Test2().invertTree(treeNode1));
    }

}
