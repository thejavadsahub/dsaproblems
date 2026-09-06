package trees;

//Author @dsa.java.hub
public class TreeTraversals {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    static void preorder(Node node, java.util.List<Integer> result) {
        if (node == null) return;
        result.add(node.value);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    static void inorder(Node node, java.util.List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.value);
        inorder(node.right, result);
    }

    static void postorder(Node node, java.util.List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.value);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        java.util.List<Integer> preResult = new java.util.ArrayList<>();
        java.util.List<Integer> inResult = new java.util.ArrayList<>();
        java.util.List<Integer> postResult = new java.util.ArrayList<>();

        preorder(root, preResult);
        inorder(root, inResult);
        postorder(root, postResult);

        System.out.println("Preorder:  " + preResult);
        System.out.println("Inorder:   " + inResult);
        System.out.println("Postorder: " + postResult);
    }
}
