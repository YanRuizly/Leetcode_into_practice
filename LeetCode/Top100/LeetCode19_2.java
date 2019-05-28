package LeetCode.Top100;


public class LeetCode19_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 ){
            return head;
        }
        ListNode forDelPre = null;
        for (ListNode currentNode = head; currentNode !=null; currentNode = currentNode.next) {

        }
        return null;
    }

    public static void main(String[] args){

    }
}
