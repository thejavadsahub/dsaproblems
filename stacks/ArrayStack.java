package stacks;

//Author @dsa.java.hub
public class ArrayStack {

    private int[] data;
    private int top;

    ArrayStack(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    void push(int value) {
        data[++top] = value;
    }

    int pop() {
        return data[top--];
    }

    int peek() {
        return data[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println("Pop: " + stack.pop());
        System.out.println("isEmpty: " + stack.isEmpty());
    }
}
