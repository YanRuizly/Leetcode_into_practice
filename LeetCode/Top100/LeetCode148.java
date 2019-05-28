package LeetCode.Top100;

import java.util.List;

/**
 *  排序链表
 *  归并排序求解
 */
public class LeetCode148 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * fast-slow 找中点
     * 分割两部分
     * 合并两个有序链表
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(newHead));
    }

    public static ListNode merge(ListNode h1,ListNode h2){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while (h1 != null && h2 != null){
            if (h1.val < h2.val){
                curr.next = h1;
                h1 = h1.next;
            }else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }
        if (h1 == null) curr.next = h2;
        else curr.next = h1;
        return dummy.next;
    }

    /**
     * 递归的 merge
     * @param h1
     * @param h2
     * @return
     */
    public static ListNode merge2(ListNode h1,ListNode h2) {
        if (h1 == null){
            return h2;
        }
        if (h2 == null){
            return h1;
        }
        ListNode head = null;
        if (h1.val <= h2.val){
            head = h1;
            head.next = merge(h1.next,h2);
        }else {
            head = h2;
            head.next = merge(h1,h2.next);
        }
        return head;
    }
}
