package stacks;

//Author @dsa.java.hub
public class BalancedParentheses {

    static boolean isBalanced(String s) {
        java.util.Deque<Character> stack = new java.util.ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (c == ')' && open != '(') return false;
                if (c == ']' && open != '[') return false;
                if (c == '}' && open != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("{[()]} -> " + isBalanced("{[()]}"));
        System.out.println("([)]   -> " + isBalanced("([)]"));
        System.out.println("(()    -> " + isBalanced("(()"));
    }
}
