package top.aranlzh;

public class Test1 {

    /**
     * 维护构建二叉树的值和值索引
     */
    public static class TreeValue {
        public static int index = 0;
        public static final int[] TREE_VALUE = new int[] { 1, 2, 3, 0, 4, 5, 0, 0, 6, 0, 0, 7, 0, 0, 8, 0, 9, 10, 0, 0, 0 };
    }

    public static TreeNode createTree(TreeNode node, int i) {
        if (0 == TreeValue.TREE_VALUE[i]) {
            return null;
        } else {
            node.setVal(TreeValue.TREE_VALUE[i]);
        }

        TreeNode leftChild = new TreeNode();
        node.left = createTree(leftChild, ++TreeValue.index);
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++TreeValue.index);

        return node;
    }

    public void showLeft(TreeNode tree) {
        if (tree != null) {
            System.out.println(tree.val);
            // 遍历左子树
            showLeft(tree.left);
        }
    }

    public void showRight(TreeNode tree) {
        if (tree != null) {
            System.out.println(tree.val);
            // 遍历右子树
            showRight(tree.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root = createTree(root, 0);
        System.out.println("遍历左子树：");
        new Test1().showLeft(root);
        System.out.println("遍历右子树：");
        new Test1().showRight(root);
    }
}
