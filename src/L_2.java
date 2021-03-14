public class L_2 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = null;
        ListNode cur = null;

        int curNum = 0;
        while (curNum != 0 || l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) a = l1.val;
            if (l2 != null) b = l2.val;
            int sum = a + b + curNum;

            curNum = sum / 10;
            int temp = sum % 10;
            System.out.println(temp);
            ListNode node = new ListNode(temp);
            if (res == null) {
                res = node;
                cur = res;
            } else {
                cur.next = node;
                cur = node;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        return res;
    }
}
