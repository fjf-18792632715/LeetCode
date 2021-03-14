public class L_147 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode node = new ListNode(Integer.MIN_VALUE);
        node.next = head;
        if (head == null || head.next == null) return node.next;

        ListNode curNode = head.next;
        ListNode preNode = head;

        while (curNode != null) {
            if (curNode.val >= preNode.val) {
                curNode = curNode.next;
                preNode = preNode.next;
                continue;
            }
            ListNode preCurNode = node;
            preNode.next = curNode.next;
            while (preCurNode != preNode && preCurNode.next.val < curNode.val) {
                preCurNode = preCurNode.next;
            }

            curNode.next = preCurNode.next;
            preCurNode.next = curNode;
            curNode = preNode.next;
        }

        return node.next;
    }

}
