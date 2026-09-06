package quicktips;

//Author @dsa.java.hub
public class RecursiveVsIterativeTraversal {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    static void recursiveInorder(Node node, java.util.List<Integer> result) {
        if (node == null) return;
        recursiveInorder(node.left, result);
        result.add(node.value);
        recursiveInorder(node.right, result);
    }

    static java.util.List<Integer> iterativeInorder(Node root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        java.util.Deque<Node> stack = new java.util.ArrayDeque<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.value);
            curr = curr.right;
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        java.util.List<Integer> recursiveResult = new java.util.ArrayList<>();
        recursiveInorder(root, recursiveResult);
        java.util.List<Integer> iterativeResult = iterativeInorder(root);

        System.out.println("Recursive inorder: " + recursiveResult);
        System.out.println("Iterative inorder: " + iterativeResult);
        System.out.println("Match: " + recursiveResult.equals(iterativeResult));
    }
}
