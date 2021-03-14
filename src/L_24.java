import java.util.List;

public class L_24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode res = null;
        ListNode cur1 = head;
        ListNode cur2 = cur1.next;
        ListNode preNode = null;

        while (cur2 != null) {
            if (preNode == null) {
                res = exchange(cur1, cur2);
                System.out.println(res.val);
                preNode = cur1;
                if (cur1.next != null) {
                    cur1 = cur1.next;
                    cur2 = cur1.next;
                } else break;
            } else {
                preNode.next = exchange(cur1, cur2);
                preNode = cur1;
                if (cur1.next != null) {
                    cur1 = cur1.next;
                    cur2 = cur1.next;
                } else break;
            }
        }
        return res;
    }

    public ListNode exchange(ListNode cur1, ListNode cur2) {
         if (cur2 == null) return cur1;
         cur1.next = cur2.next;
         cur2.next = cur1;

         return cur2;
    }
}
