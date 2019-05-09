package LeetCode.BFS;

public class LeetCode102_digui {
    public static void levelOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        int depth = depth(node);
        for (int i = 1; i <= depth; i++) {
            levelOrder(node, i);
            System.out.println();
        }
    }

    private static void levelOrder(TreeNode node, int level) {
        if (node == null || level < 1) {
            return;
        }
        if (level == 1) {
            System.out.print(node.val + "  ");
            return;
        }
        // 左子树
        levelOrder(node.left, level - 1);
        // 右子树
        levelOrder(node.right, level - 1);
    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.print("递归层序遍历：\n");
        levelOrder(root);
    }
}
