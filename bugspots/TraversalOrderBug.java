package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
public class TraversalOrderBug {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    static void inorder(Node node, java.util.List<Integer> result) {
        if (node == null) return;
        inorder(node.right, result); // BUG: right visited before left
        result.add(node.value);
        inorder(node.left, result);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        java.util.List<Integer> result = new java.util.ArrayList<>();
        inorder(root, result);
        System.out.println("\"Inorder\" result: " + result);
    }
}
