package LeetCode.BFS;

import java.util.*;

import LeetCode.BFS.LeetCode101;

public class LeetCode107 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
               Deque<TreeNode> queue = new LinkedList<>();
        TreeNode curNode = root;
        int current = 0;
        int next = 0;
        if (curNode != null)
            queue.add(curNode);
        //加入根节点
        current = 1;
        List<Integer> tmplist = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            //取出当前层节点
            tmplist.add(tempNode.val);
            current--;
            if(tempNode.left != null) {
                queue.addLast(tempNode.left);
                next++;
            }
            if(tempNode.right != null) {
                queue.addLast(tempNode.right);
                next++;
            }
            if(current==0){//当前层打印完了
                lists.add(new ArrayList<>(tmplist));
                tmplist.clear();
                current = next;
                next = 0;
            }
        }
        Collections.reverse(lists);
        return lists;
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
        System.out.println(levelOrderBottom(root));
    }
}
