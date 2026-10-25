package unionfind;

//Author @dsa.java.hub
import java.util.Arrays;

/**
 * LeetCode 547: Number of Provinces (Union-Find, union by size).
 * Every city starts as its own set. union(a, b) joins the two sets, attaching the smaller one under
 * the bigger one. If a and b already share a root, the edge adds nothing. The number of sets left
 * at the end is the number of provinces.
 */
public class NumberOfProvinces {

    static int[] parent = new int[8];
    static int[] size = new int[8];
    static int sets = 8;

    static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];                        // path compression: skip a level while walking up
            x = parent[x];
        }
        return x;
    }

    static String union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return "find(" + a + ")=" + rootA + " find(" + b + ")=" + rootB + " same root -> skip (cycle)";
        }
        if (size[rootA] < size[rootB]) {                          // the smaller set goes under the bigger one
            int swap = rootA;
            rootA = rootB;
            rootB = swap;
        }
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
        sets--;
        return "root " + rootB + " under " + rootA;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int[][] connections = {{0, 1}, {1, 2}, {3, 4}, {5, 6}, {6, 7}, {0, 2}, {4, 6}};
        for (int[] c : connections) {
            String what = union(c[0], c[1]);
            System.out.printf("union(%d,%d): %-45s parent=%s sets=%d%n", c[0], c[1], what, Arrays.toString(parent), sets);
        }
        System.out.println("provinces = " + sets);
    }
}
