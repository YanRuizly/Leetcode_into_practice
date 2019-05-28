package LeetCode.Top100;

import java.util.HashSet;
import java.util.Set;

/**
 *  环形链表Ⅱ
 */
public class LeetCode142 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 判断是否有环
     * @param head
     * @return
     */
    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 超时
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow!=null&&fast!=null&&fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //快慢指针的处理只能判断是否有环,并不能判断出在哪里出现的环
            if(fast == slow){
                //循环链表的head  如果head和slow中的某一个节点出现相同
                //代表在链表的该条直线上,出现了环
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 超时
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null && fast != null && fast.next != null){
            fast = fast.next;
            if(slow == fast){
                while(head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }

    public ListNode detectCycle3(ListNode head) {
        if (head == null){
            return head;
        }
        HashSet<ListNode> listNodeHashSet = new HashSet<>();
        boolean result = false;
        while (listNodeHashSet.add(head)){
            if (head.next == null){
                result = true;
                break;
            }
            head = head.next;
        }
        return result ? null : head;
    }


    public static void main(String[] args){

    }
}
