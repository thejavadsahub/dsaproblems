package trees;

//Author @dsa.java.hub
public class BinarySearchTree {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value) node.left = insert(node.left, value);
        else if (value > node.value) node.right = insert(node.right, value);
        return node;
    }

    boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) return false;
        if (value == node.value) return true;
        return value < node.value ? search(node.left, value) : search(node.right, value);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            bst.insert(v);
        }

        System.out.println("Search 40 (exists): " + bst.search(40));
        System.out.println("Search 45 (missing): " + bst.search(45));
    }
}
