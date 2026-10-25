package backtracking;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 79: Word Search (backtracking on a grid).
 * Start a depth-first search from every cell that matches the first letter. At each step try the 4
 * neighbours for the next letter. A cell must not be used twice in one path, so mark it while it is on
 * the path (here with '#') and put the letter back when the search backs out of it.
 */
public class WordSearch {

    static int dfsCalls;

    static boolean dfs(char[][] board, int r, int c, String word, int index, List<String> path) {
        dfsCalls++;
        if (index == word.length()) return true;                         // every letter matched
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;
        if (board[r][c] != word.charAt(index)) return false;             // wrong letter, or a cell already on the path ('#')

        char letter = board[r][c];
        board[r][c] = '#';                                               // choose: this cell is now on the path
        path.add("(" + r + "," + c + ")");
        boolean found = dfs(board, r + 1, c, word, index + 1, path)
                || dfs(board, r - 1, c, word, index + 1, path)
                || dfs(board, r, c + 1, word, index + 1, path)
                || dfs(board, r, c - 1, word, index + 1, path);
        board[r][c] = letter;                                            // undo
        if (!found) path.remove(path.size() - 1);
        return found;
    }

    public static void main(String[] args) {
        String[] rows = {"ABCE", "SFCS", "ADEE"};
        System.out.println("board:");
        for (String row : rows) System.out.println("  " + row);

        for (String word : new String[]{"ABCCED", "SEE", "ABCB"}) {
            char[][] board = new char[rows.length][];
            for (int i = 0; i < rows.length; i++) board[i] = rows[i].toCharArray();

            dfsCalls = 0;
            List<String> path = new ArrayList<>();
            boolean found = false;
            for (int r = 0; r < board.length && !found; r++) {
                for (int c = 0; c < board[0].length && !found; c++) {
                    found = dfs(board, r, c, word, 0, path);
                }
            }
            System.out.println("\"" + word + "\" -> " + found + (found ? "  path " + String.join("", path) : "")
                    + "  (" + dfsCalls + " dfs calls)");
        }
    }
}
