package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
public class ValidateBstBug {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    // BUG: only compares each node against its immediate children,
    // never checks against the full valid range inherited from ancestors.
    static boolean isValidBst(Node node) {
        if (node == null) return true;
        if (node.left != null && node.left.value >= node.value) return false;
        if (node.right != null && node.right.value <= node.value) return false;
        return isValidBst(node.left) && isValidBst(node.right);
    }

    public static void main(String[] args) {
        // 60 is a valid right child of 30 locally, but it's > 50 while sitting in 50's left subtree - not a real BST.
        Node invalid = new Node(50);
        invalid.left = new Node(30);
        invalid.right = new Node(70);
        invalid.left.right = new Node(60);

        System.out.println("Is this a valid BST? " + isValidBst(invalid));
    }
}
