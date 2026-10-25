package hashing;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49: Group Anagrams.
 * Words that are anagrams become the SAME string when their letters are sorted ("eat", "tea" and "ate"
 * all become "aet"). Use that sorted string as a hash map key and every anagram group collects itself.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> groups = new LinkedHashMap<>();
        for (String word : words) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);                      // the same for every anagram of this word
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
            System.out.println(word + " -> key \"" + key + "\" -> group " + groups.get(key));
        }
        System.out.println("groups: " + groups.values());
    }
}
