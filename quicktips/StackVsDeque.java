package quicktips;

//Author @dsa.java.hub
public class StackVsDeque {

    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack (legacy, synchronized) pop: " + stack.pop());

        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println("Deque (ArrayDeque, preferred) pop: " + deque.pop());
    }
}
