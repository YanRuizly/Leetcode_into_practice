package LeetCode.Top100;

import java.util.*;

/**
 *  二叉树的层序遍历
 */
public class LeetCode102 {
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        int pCount  = 0;
        int pNext = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            pCount = pNext;
            pNext = 0;
            for (int i=0;i<pCount;i++){
                TreeNode node = queue.getFirst();
                list.add(node.val);
                queue.pollFirst();
                if (node.left != null){
                    queue.addLast(node.left);
                    pNext++;
                }
                if(node.right != null){
                    queue.addLast(node.right);
                    pNext++;
                }
            }
            lists.add(new ArrayList<>(list));
            list.clear();
        }
        return lists;
    }

    public static void main(String[] args){
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        node7.left = node8;
        List<List<Integer>> lists = levelOrder(node3);
        System.out.println(lists);
    }
}
