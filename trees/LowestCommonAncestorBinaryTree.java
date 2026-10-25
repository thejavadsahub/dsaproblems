package trees;

//Author @dsa.java.hub

/**
 * LeetCode 236: Lowest Common Ancestor of a Binary Tree (any binary tree, not only a BST).
 * LowestCommonAncestor.java uses the BST ordering rule (smaller values go left), which does not work here
 * because the values of this tree are not ordered. Instead, ask both subtrees "do you contain p or q?":
 *   - found on BOTH sides      -> this node is the lowest common ancestor;
 *   - found on ONE side only   -> pass that answer up;
 *   - this node IS p or q      -> return it (if the other target is below, this node is the ancestor).
 * The trace prints from the bottom up, so children report before their parents (deeper = more indent).
 */
public class LowestCommonAncestorBinaryTree {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static Node lca(Node node, Node p, Node q, int depth) {
        if (node == null) return null;
        String indent = "  ".repeat(depth);
        if (node == p || node == q) {
            System.out.println(indent + "node " + node.value + " is one of the targets -> return it");
            return node;
        }
        Node fromLeft = lca(node.left, p, q, depth + 1);
        Node fromRight = lca(node.right, p, q, depth + 1);
        if (fromLeft != null && fromRight != null) {
            System.out.println(indent + "node " + node.value + ": a target on each side (" + fromLeft.value + " and "
                    + fromRight.value + ") -> this is the LCA");
            return node;
        }
        Node found = fromLeft != null ? fromLeft : fromRight;
        System.out.println(indent + "node " + node.value + ": "
                + (found == null ? "no target below -> return null" : "target only on one side -> pass " + found.value + " up"));
        return found;
    }

    public static void main(String[] args) {
        //          3
        //        /   \
        //       5     1
        //      / \   / \
        //     6   2 0   8
        //        / \
        //       7   4
        Node n3 = new Node(3), n5 = new Node(5), n1 = new Node(1), n6 = new Node(6), n2 = new Node(2);
        Node n0 = new Node(0), n8 = new Node(8), n7 = new Node(7), n4 = new Node(4);
        n3.left = n5;
        n3.right = n1;
        n5.left = n6;
        n5.right = n2;
        n1.left = n0;
        n1.right = n8;
        n2.left = n7;
        n2.right = n4;

        System.out.println("LCA of 5 and 1:");
        System.out.println("answer = " + lca(n3, n5, n1, 0).value);
        System.out.println();
        System.out.println("LCA of 5 and 4 (4 is below 5, so 5 is its own ancestor):");
        System.out.println("answer = " + lca(n3, n5, n4, 0).value);
        System.out.println();
        System.out.println("LCA of 7 and 4:");
        System.out.println("answer = " + lca(n3, n7, n4, 0).value);
    }
}
