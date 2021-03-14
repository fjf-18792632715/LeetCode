public class L_148 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = head;
        ListNode right = head;

        while (right.next != null) right = right.next;
        return sort(left, right);

    }

    public ListNode sort(ListNode left, ListNode right) {
        if (left == right) return left;
        if (left.next == right) {
            left.next = null;
            return merage(left, right);
        }

        ListNode slow = left;
        ListNode fast = left;
        while (fast != right) {
            slow = slow.next;
            fast = fast.next;
            if (fast != right) fast = fast.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode listLeft = sort(left, slow);
        ListNode listRight = sort(mid, right);

        // 对两个有序链表排序
        return merage(listLeft, listRight);
    }

    // 对两个有序链表排序
    public ListNode merage(ListNode L1, ListNode L2){
        if (L1 == null) return L2;
        if (L2 == null) return L1;
        ListNode tempNode = new ListNode(-1);
        ListNode node = tempNode;

        ListNode cur1 = L1;
        ListNode cur2 = L2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                node.next = cur1;
                cur1 = cur1.next;
                node = node.next;
                node.next = null;
            } else {
                node.next = cur2;
                cur2 = cur2.next;
                node = node.next;
                node.next = null;
            }
        }

        if (cur1 == null) node.next = cur2;
        if (cur2 == null) node.next = cur1;

        return tempNode.next;
    }
}
