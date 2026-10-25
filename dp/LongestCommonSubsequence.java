package dp;

//Author @dsa.java.hub

/**
 * LeetCode 1143: Longest Common Subsequence (dynamic programming table).
 * table[i][j] = the length of the LCS of the first i letters of a and the first j letters of b.
 *   letters equal      -> 1 + table[i-1][j-1]   (extend the common subsequence)
 *   letters different  -> max(table[i-1][j], table[i][j-1])   (drop one letter from either string)
 * Walking back from the bottom-right corner reads out the subsequence itself.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String a = "abcde";
        String b = "ace";
        int[][] table = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        System.out.println("a = \"" + a + "\", b = \"" + b + "\"");
        StringBuilder header = new StringBuilder("       \"\"");
        for (char c : b.toCharArray()) header.append(String.format("%3c", c));
        System.out.println(header);
        for (int i = 0; i <= a.length(); i++) {
            StringBuilder row = new StringBuilder(i == 0 ? "   \"\"  " : "    " + a.charAt(i - 1) + "  ");
            for (int j = 0; j <= b.length(); j++) row.append(String.format("%3d", table[i][j]));
            System.out.println(row);
        }

        StringBuilder common = new StringBuilder();                      // walk back from the bottom-right corner
        int i = a.length();
        int j = b.length();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                common.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (table[i - 1][j] >= table[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("answer = " + table[a.length()][b.length()] + " (the subsequence \"" + common.reverse() + "\")");
    }
}
