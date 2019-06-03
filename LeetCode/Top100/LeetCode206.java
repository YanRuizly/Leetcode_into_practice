package LeetCode.Top100;


/**
*   反转链表
*   
*/

public class LeetCode206{
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        //ListNode dummy = new ListNode(-1);
        //dummy.next = head;
        ListNode pre = null;
        ListNode curr = head;
        ListNode pnext = curr;
        while(curr != null){
            /*保存当前节点的下一个指针指向 */
            pnext = curr.next; 
            curr.next = pre;
            /* 处理下一个节点  */
            pre = curr;
            curr = pnext;
        }
        return pre;
    }
}