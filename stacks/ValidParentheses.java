package stacks;

//Author @dsa.java.hub
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 20: Valid Parentheses, with a push/pop trace.
 * Push every opening bracket. Every closing bracket must match the bracket on top of the stack.
 * (BalancedParentheses.java solves the same problem; this version prints each stack step.)
 */
public class ValidParentheses {

    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                System.out.println("  push " + c + "  stack=" + stack);
            } else {
                char wanted = c == ')' ? '(' : c == ']' ? '[' : '{';
                if (stack.isEmpty()) {
                    System.out.println("  " + c + " but stack empty -> false");
                    return false;
                }
                char top = stack.pop();
                System.out.println("  " + c + " pops " + top + (top == wanted ? " match" : " MISMATCH -> false")
                        + "  stack=" + stack);
                if (top != wanted) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        for (String s : new String[]{"{[()()]}", "([)]"}) {
            System.out.println(s + ":");
            System.out.println(" -> " + isValid(s));
        }
    }
}
