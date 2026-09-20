package quicktips;

//Author @dsa.java.hub
public class BfsVsDfs {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    static java.util.List<Integer> bfs(Node root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.value);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return result;
    }

    static void dfs(Node node, java.util.List<Integer> result) {
        if (node == null) return;
        result.add(node.value);
        dfs(node.left, result);
        dfs(node.right, result);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        // BFS: extra space is O(width) - best for "shortest path / closest node" problems.
        // DFS: extra space is O(height) - simpler to write recursively.
        java.util.List<Integer> dfsResult = new java.util.ArrayList<>();
        dfs(root, dfsResult);

        System.out.println("BFS: " + bfs(root));
        System.out.println("DFS: " + dfsResult);
    }
}
