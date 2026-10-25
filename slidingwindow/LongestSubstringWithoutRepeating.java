package slidingwindow;

//Author @dsa.java.hub
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3: Longest Substring Without Repeating Characters (sliding window).
 * The window s[left..right] never contains a repeated letter. Move right one step at a time. If the new
 * letter is already inside the window, jump left to just after its previous position.
 * A map from letter to its last index lets left jump straight there instead of crawling.
 */
public class LongestSubstringWithoutRepeating {

    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int best = 0;
        for (int right = 0; right < s.length(); right++) {
            char letter = s.charAt(right);
            String note = "";
            Integer previous = lastSeen.get(letter);
            if (previous != null && previous >= left) {
                left = previous + 1;                              // the letter repeats inside the window: shrink from the left
                note = "  '" + letter + "' was at index " + previous + " -> left jumps to " + left;
            }
            lastSeen.put(letter, right);
            best = Math.max(best, right - left + 1);
            System.out.println("right=" + right + " '" + letter + "'  window=\"" + s.substring(left, right + 1)
                    + "\"  length=" + (right - left + 1) + "  best=" + best + note);
        }
        return best;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("s = \"" + s + "\"");
        System.out.println("answer = " + lengthOfLongestSubstring(s));
    }
}
