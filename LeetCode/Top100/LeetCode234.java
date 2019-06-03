package LeetCode.Top100;

import java.util.Stack;

/**
 *   回文链表
 */
public class LeetCode234 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while(node != null){
            stack.push(node.val);
            node = node.next;  
        }
        while(head != null){
            if(head.val != stack.peek()){
                return false;
            }
            head = head.next;
            stack.pop();
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseList(slow.next);
        while(slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }


    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
     
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