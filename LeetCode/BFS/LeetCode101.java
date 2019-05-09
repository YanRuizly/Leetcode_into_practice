package LeetCode.BFS;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}

public class LeetCode101 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left,root.right);
    }

    public static boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left == null && right == null)
            return true;
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        if(isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left)){
            return  true;
        }
        return false;
    }

    public static void main(String[] args){
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
        System.out.println(isSymmetric(root));


        TreeNode root2 = new TreeNode(1);
        System.out.println(isSymmetric(root2));

    }
}
