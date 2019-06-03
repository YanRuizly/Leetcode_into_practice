package LeetCode.Top100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *  相交链表
 */
public class LeetCode160 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
