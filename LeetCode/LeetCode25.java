package LeetCode;

import yanrui.DataStructure.Collection.List.List;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;
        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        // 满足条件，进行翻转
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if (next != null) {
                // head 为链表翻转后的尾节点
                head.next = reverseKGroup(next, k);
            }
            // prev 为链表翻转后的头结点
            return prev;
        } else {
            // 不满住翻转条件，直接返回 head 即可
            return head;
        }
    }

    //单链表的反转，头插法
    public ListNode reverseList(ListNode head) {
        ListNode dummy  = new ListNode(-1);
        ListNode h = dummy.next;
        dummy.next = head;
        ListNode pre = dummy.next;
        ListNode pCur = pre.next;
        while (pCur!=null){
            pre.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = pCur.next;
        }
        return h;
    }

    public static void main(String[] args){

    }
}