package LeetCode.Top100;

/**
 *  合并两个有序链表
 *  1、递归
 *  2、非递归
 * @author YANRUI
 */
public class LeetCode21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode l3 = new ListNode(-1);
        ListNode pre = l3;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                l3.next = new ListNode(l1.val);
            }else {
                l3.next = new ListNode(l2.val);
            }
            l3 = l3.next;
        }
        if (l1 != null){
            l3.next = l1;
        }
        if (l2 != null){
            l3.next = l2;
        }
        return pre.next;
    }


    public static void main(String[] args){

    }
}
