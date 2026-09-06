package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
public class LcaBug {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    // BUG: assumes BST ordering to decide which way to go,
    // but this tree's values don't follow the BST property at all.
    static Node lca(Node node, int a, int b) {
        if (node == null) return null;
        if (a < node.value && b < node.value) return lca(node.left, a, b);
        if (a > node.value && b > node.value) return lca(node.right, a, b);
        return node;
    }

    public static void main(String[] args) {
        // Not a BST - values placed arbitrarily.
        Node root = new Node(50);
        root.left = new Node(80);
        root.right = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(90);

        // The real LCA of 10 and 90 is 80 (their direct parent).
        Node result = lca(root, 10, 90);
        System.out.println("LCA of 10 and 90 (actual answer should be 80): " + result.value);
    }
}
