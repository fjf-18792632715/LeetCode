import java.util.HashMap;
import java.util.Map;

public class L_138 {

// Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        if (head == null) return null;
        Node preHead = new Node(-1);
        Node curNode = head;
        Node pre = preHead;
        while (curNode != null) {
            Node node = new Node(curNode.val);
            node.random = curNode.random;
            map.put(curNode, node);
            pre.next = node;
            pre = node;
            curNode = curNode.next;
        }


        Node cur = preHead.next;
        while (cur != null) {
            if (cur.random == null) {
                cur = cur.next;
                continue;
            }

            cur.random = map.get(cur.random);
            cur = cur.next;
        }

        return preHead.next;

    }
}
