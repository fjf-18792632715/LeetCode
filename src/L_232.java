import java.util.Deque;
import java.util.LinkedList;

public class L_232 {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    /** Initialize your data structure here. */
    public L_232() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack2.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) return 0;
        if (stack1.isEmpty()) {
            copyOneToTwo();
        }
        return stack1.pop();
    }

    public void copyOneToTwo(){
        if (stack2.isEmpty())  return;
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) return 0;
        if (stack1.isEmpty()) {
            copyOneToTwo();
        }
        return stack1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
