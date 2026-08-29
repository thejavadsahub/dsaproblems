package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
public class EmptyStackPopBug {

    public static void main(String[] args) {
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
        stack.push(1);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop()); // BUG: stack is already empty
    }
}
