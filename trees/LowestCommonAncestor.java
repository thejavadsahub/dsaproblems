package trees;

//Author @dsa.java.hub
public class LowestCommonAncestor {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    // Uses the BST ordering property: if both values are smaller, go left;
    // if both are bigger, go right; otherwise this node is the split point (the LCA).
    static Node lca(Node node, int a, int b) {
        if (node == null) return null;
        if (a < node.value && b < node.value) return lca(node.left, a, b);
        if (a > node.value && b > node.value) return lca(node.right, a, b);
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        Node result1 = lca(root, 20, 40);
        Node result2 = lca(root, 20, 80);
        System.out.println("LCA of 20 and 40: " + result1.value);
        System.out.println("LCA of 20 and 80: " + result2.value);
    }
}
