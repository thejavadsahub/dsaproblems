package trees;

//Author @dsa.java.hub
public class LevelOrderTraversal {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    static void levelOrder(Node root) {
        if (root == null) return;
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            java.util.List<Integer> levelValues = new java.util.ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                levelValues.add(node.value);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println("Level " + level + ": " + levelValues);
            level++;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        levelOrder(root);
    }
}
