package quicktips;

//Author @dsa.java.hub
public class RecursionForTreeHeight {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    // height(node) = 1 + max(height(left), height(right))
    // Each recursive call answers the exact same question for a smaller tree,
    // and the base case (null -> 0) is what stops it. No manual bookkeeping needed.
    static int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        System.out.println("Node " + node.value + " -> left height " + leftHeight + ", right height " + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);

        System.out.println("Final height: " + height(root));
    }
}
