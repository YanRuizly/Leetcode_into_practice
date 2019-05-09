package LeetCode;
 //* Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class LeetCode124 {
    private static int max = Integer.MIN_VALUE;
    public static int maxPathSum1(TreeNode root) {
        maxPathSum(root);
        return max;
    }

    public static int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        System.out.println(root.val);
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.left);
        //连接父节点的最大路径是一、二、四这三种情况的最大值
        int currSum = Math.max(Math.max(left + root.val, right + root.val), root.val);
        //当前节点的最大路径是一、二、三、四这四种情况的最大值
        int currMax = Math.max(currSum, left + right + root.val);
        //用当前最大来更新全局最大
        max = Math.max(currMax, max);
        return currMax;
    }

    public static void PriOrder(TreeNode root) {
        if(root == null){
            return;
        }
        PriOrder(root.left);
        System.out.println(root.val);
        PriOrder(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node4;
        node2.left = node3;
        node2.right = null;
        node4.left = node5;
        node4.right = node6;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;

        System.out.println(maxPathSum1(root));
    }
}
