package LeetCode;

import yanrui.DataStructure.Collection.List.List;

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h;
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode lat = null;
        while (pre.next != null && pre.next.next != null){
            node1 = pre.next;
            node2 = node1.next;
            lat = node2.next;

            pre.next = node2;
            node2.next = node1;
            node1.next = lat;

            pre = node1;
        }
        return h.next;
    }

    public static void main(String[] args){

    }
}
