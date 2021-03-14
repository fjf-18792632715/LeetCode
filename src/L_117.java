import java.util.Deque;
import java.util.LinkedList;

public class L_117 {

    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        if (root == null) return null;

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        int count;

        while (!queue.isEmpty()) {
            Node[] nodes = queue.toArray(new Node[0]);
            for (Node node : nodes) {
                System.out.print("  " + node.val);
            }
            count = queue.size();
            Node temp = queue.poll();
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);

            for (int i = 0; i < count - 1; i++) {
                temp.next = queue.poll();
                if (temp.next == null) break;
                if (temp.next.left != null) queue.offer(temp.next.left);
                if (temp.next.right != null) queue.offer(temp.next.right);
                temp = temp.next;
            }
        }

        return root;

    }


}
