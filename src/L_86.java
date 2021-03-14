public class L_86 {

     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode partition(ListNode head, int x) {
         if (head == null || head.next == null) return head;
        ListNode topLeft = new ListNode(-1);
        ListNode newCurLeft = topLeft;
        ListNode topRight = new ListNode(-1);
        ListNode newCurRight = topRight;

        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode != null) {
            preNode = curNode;
            curNode = curNode.next;
            preNode.next = null;

            if (preNode.val < x) {
                newCurLeft.next = preNode;
                newCurLeft = preNode;
            } else {
                newCurRight.next = preNode;
                newCurRight = preNode;
            }
        }

        if (topLeft.next == null) return topRight.next;
        newCurLeft.next = topRight.next;
        return topLeft.next;
    }

}
