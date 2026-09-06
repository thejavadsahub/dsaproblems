package trees;

//Author @dsa.java.hub
public class BinaryTreeBasics {

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

    void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String prefix, boolean isRoot) {
        if (node == null) return;
        System.out.println(prefix + (isRoot ? "" : "-- ") + node.value);
        String childPrefix = prefix + (isRoot ? "" : "   ");
        printTree(node.left, childPrefix + "|", false);
        printTree(node.right, childPrefix + "|", false);
    }

    public static void main(String[] args) {
        BinaryTreeBasics tree = new BinaryTreeBasics();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            tree.insert(v);
        }
        tree.printTree();
    }
}
