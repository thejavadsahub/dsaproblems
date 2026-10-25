package graphs;

//Author @dsa.java.hub

/**
 * LeetCode 200: Number of Islands (DFS flood fill).
 * Scan the grid. Every time you find an unvisited '1', that is a new island: count it, then DFS to
 * sink the whole island (turn its '1's into '0's) so it is never counted again.
 */
public class NumberOfIslands {

    static char[][] grid;
    static StringBuilder visitOrder = new StringBuilder();

    static void sink(int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') return;
        grid[r][c] = '0';                                         // mark as visited
        visitOrder.append("(").append(r).append(",").append(c).append(")");
        sink(r + 1, c);                                           // down
        sink(r - 1, c);                                           // up
        sink(r, c + 1);                                           // right
        sink(r, c - 1);                                           // left
    }

    public static void main(String[] args) {
        String[] rows = {"1100100", "1100110", "0010000", "0001011", "1101011", "1100001"};
        grid = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) grid[i] = rows[i].toCharArray();

        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    visitOrder.setLength(0);
                    sink(r, c);
                    System.out.println("island " + islands + ": " + visitOrder);
                }
            }
        }
        System.out.println("numIslands = " + islands);
    }
}
