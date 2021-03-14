import java.util.List;

public class L_328 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;


        ListNode cur1 = head;
        ListNode cur2 = head.next;
        ListNode temp = cur2;

        while (cur1.next != null && cur2.next != null) {
            cur1.next = cur2.next;
            cur1 = cur1.next;
            cur2.next = cur1.next;
            cur2 = cur2.next;
        }

//        if (cur1.next == null) {
//            cur1.next = temp;
//        } else {
//            cur1.next.next = temp;
//        }
        cur1.next = temp;

        return head;
    }

}
