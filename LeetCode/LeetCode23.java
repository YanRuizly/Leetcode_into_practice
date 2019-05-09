package LeetCode;

public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        for(int i=0;i<lists.length;i++){
            listNode = mergeTwoLists(listNode,lists[i]);
        }
        return listNode;
    }


    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


    public static void main(String[] args){

    }
}
