package tries;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * LeetCode 208: Implement Trie, used for autocomplete.
 * A trie stores words letter by letter along a path, so words that share a prefix share nodes.
 * To autocomplete "ca": walk 2 steps down, then collect every word below that node.
 */
public class TrieAutocomplete {

    static class Node {
        Map<Character, Node> children = new TreeMap<>();          // sorted, so results come out alphabetically
        boolean endOfWord;
    }

    static Node root = new Node();
    static int nodeCount = 1;                                     // counts the root too

    static void insert(String word) {
        Node node = root;
        for (char letter : word.toCharArray()) {
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new Node());
                nodeCount++;
            }
            node = node.children.get(letter);
        }
        node.endOfWord = true;
    }

    /** Adds every word at or below this node to 'out'; 'prefix' is the letters on the path so far. */
    static void collect(Node node, StringBuilder prefix, List<String> out) {
        if (node.endOfWord) out.add(prefix.toString());
        for (Map.Entry<Character, Node> child : node.children.entrySet()) {
            prefix.append(child.getKey());
            collect(child.getValue(), prefix, out);
            prefix.setLength(prefix.length() - 1);                // backtrack one letter
        }
    }

    public static void main(String[] args) {
        String[] words = {"car", "card", "care", "cat", "dog", "dot"};
        for (String word : words) insert(word);
        System.out.println("words " + words.length + ", letters " + String.join("", words).length()
                + ", trie nodes " + nodeCount + " (incl. root)");

        Node node = root;
        int steps = 0;
        for (char letter : "ca".toCharArray()) {
            node = node.children.get(letter);
            steps++;
        }
        List<String> suggestions = new ArrayList<>();
        collect(node, new StringBuilder("ca"), suggestions);
        System.out.println("prefix \"ca\": " + steps + " steps down -> " + suggestions);
    }
}
