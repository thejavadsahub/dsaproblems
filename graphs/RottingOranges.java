package graphs;

//Author @dsa.java.hub
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode 994: Rotting Oranges (multi-source BFS).
 * 0 = empty, 1 = fresh orange, 2 = rotten orange. Every minute, each fresh orange next to a rotten one
 * (up, down, left, right) rots. Put ALL rotten oranges in the queue at the start and spread out
 * level by level: one level of BFS is exactly one minute. If a fresh orange is left at the end
 * (walled off by empty cells), the answer is -1.
 */
public class RottingOranges {

    static int minutes(int[][] original) {
        int rows = original.length;
        int cols = original[0].length;
        int[][] grid = new int[rows][];
        for (int i = 0; i < rows; i++) grid[i] = original[i].clone();

        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.add(new int[]{r, c});         // every rotten orange starts the spreading
                else if (grid[r][c] == 1) fresh++;
            }
        }
        System.out.println("start: " + queue.size() + " rotten, " + fresh + " fresh");

        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minute = 0;
        while (!queue.isEmpty() && fresh > 0) {
            List<String> rotted = new ArrayList<>();
            for (int size = queue.size(); size > 0; size--) {              // process exactly one minute
                int[] cell = queue.poll();
                for (int[] move : moves) {
                    int r = cell[0] + move[0];
                    int c = cell[1] + move[1];
                    if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 1) continue;
                    grid[r][c] = 2;
                    fresh--;
                    queue.add(new int[]{r, c});
                    rotted.add("(" + r + "," + c + ")");
                }
            }
            if (rotted.isEmpty()) {
                System.out.println("nothing new rots: the " + fresh + " fresh orange(s) left cannot be reached");
                break;
            }
            minute++;
            System.out.println("minute " + minute + ": " + String.join(" ", rotted) + " rot  -> " + fresh + " fresh left");
        }
        return fresh == 0 ? minute : -1;
    }

    public static void main(String[] args) {
        System.out.println("grid [[2,1,1],[1,1,0],[0,1,1]]:");
        System.out.println("answer = " + minutes(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println();
        System.out.println("grid [[2,1,1],[0,1,1],[1,0,1]] (the orange at row 2, column 0 is cut off by empty cells):");
        System.out.println("answer = " + minutes(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }
}
