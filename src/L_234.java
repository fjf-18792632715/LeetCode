import java.util.LinkedList;
import java.util.Queue;

public class L_234 {
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public boolean isPalindrome(ListNode head) {
         if (head == null || head.next == null) return true;
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        ListNode endNode = reverseList(slowNode);

        ListNode curNode = head;
        while (curNode != endNode && curNode.next != endNode) {
            if (curNode.val != endNode.val) {
                return false;
            } else {
                curNode = curNode.next;
                endNode = endNode.next;
            }
        }

        if (curNode.val != endNode.val) return false;
        return true;
    }

    public ListNode reverseList(ListNode head) {
         if (head == null || head.next == null) return head;
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode;

        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }
}
