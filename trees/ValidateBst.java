package trees;

//Author @dsa.java.hub
public class ValidateBst {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    static boolean isValidBst(Node node) {
        return isValidBst(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBst(Node node, long min, long max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false;
        return isValidBst(node.left, min, node.value) && isValidBst(node.right, node.value, max);
    }

    public static void main(String[] args) {
        Node valid = new Node(50);
        valid.left = new Node(30);
        valid.right = new Node(70);
        valid.left.left = new Node(20);
        valid.left.right = new Node(40);
        valid.right.left = new Node(60);
        valid.right.right = new Node(80);
        System.out.println("Valid BST: " + isValidBst(valid));

        // 60 is a valid right child of 30 locally, but it's > 50 while sitting in 50's left subtree.
        Node invalid = new Node(50);
        invalid.left = new Node(30);
        invalid.right = new Node(70);
        invalid.left.right = new Node(60);
        System.out.println("Invalid BST (60 sits in left subtree of 50 but is > 50): " + isValidBst(invalid));
    }
}
