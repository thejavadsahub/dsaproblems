package graphs;

//Author @dsa.java.hub
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * BFS shortest path in a grid. S is the start, E the exit, # a wall.
 * BFS explores cells in rings of equal distance from the start, so the first time it reaches E it
 * has found a shortest path. A "parent" for every cell lets us walk the path back from E.
 */
public class GridShortestPathBfs {

    public static void main(String[] args) {
        String[] grid = {
                "S..#...",
                "##.#.#.",
                ".....#.",
                ".###.#.",
                "...#...",
                "##.###.",
                "......E"};
        int n = grid.length;

        int[][] distance = new int[n][n];
        for (int[] row : distance) Arrays.fill(row, -1);          // -1 = not reached yet
        int[][] parent = new int[n * n][];
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};       // down, up, right, left

        distance[0][0] = 0;
        queue.add(new int[]{0, 0});
        int cellsReached = 1;

        search:
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] move : moves) {
                int r = cell[0] + move[0];
                int c = cell[1] + move[1];
                if (r < 0 || c < 0 || r >= n || c >= n) continue;             // outside the grid
                if (grid[r].charAt(c) == '#' || distance[r][c] >= 0) continue; // wall, or already reached
                distance[r][c] = distance[cell[0]][cell[1]] + 1;
                parent[r * n + c] = cell;
                queue.add(new int[]{r, c});
                cellsReached++;
                if (grid[r].charAt(c) == 'E') break search;                    // first arrival = shortest path
            }
        }
        System.out.println("shortest path length = " + distance[6][6] + ", cells reached = " + cellsReached);

        List<String> path = new ArrayList<>();
        int[] step = {6, 6};
        while (step != null) {
            path.add("(" + step[0] + "," + step[1] + ")");
            step = parent[step[0] * n + step[1]];
        }
        Collections.reverse(path);
        System.out.println(String.join(" ", path));
    }
}
