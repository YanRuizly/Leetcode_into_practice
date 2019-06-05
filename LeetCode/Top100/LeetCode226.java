package LeetCode.Top100;

import java.util.Queue;


/**
 *  反转二叉树
 *  1、DFS 递归
 *  2、BFS 队列
 */
public class LeetCode226 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree1(right);
            root.right = invertTree1(left);
        } 
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new ArrayQueue<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            /* 交换左右节点 */
            node.left = node.right;
            node.right = tmp;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}
