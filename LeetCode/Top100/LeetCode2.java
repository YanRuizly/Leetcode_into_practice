package LeetCode.Top100;


import yanrui.DataStructure.Collection.List.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class LeetCode2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;//进位
        int sum = 0;//和
        while (l1 != null || l2 != null){
            int x = 0;
            int y = 0;
            if (l1 != null) x = l1.val;
            if (l2 != null) y = l2.val;
            sum = carry + x + y;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if (l1 != null) l1= l1.next;
            if (l2 != null) l2= l2.next;
        }
        if (carry > 0)
            curr.next = new ListNode(carry);
        return dummyHead.next;
    }


    public static void main(String[] args){
        ListNode head1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        head1.next = node2;
        node2.next = node3;

        ListNode head2 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        head2.next = node4;
        node4.next = node5;
        ListNode newList = addTwoNumbers(head1,head2);
    }
}
