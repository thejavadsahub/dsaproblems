package design;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 146: LRU Cache, built from scratch with a HashMap and a doubly linked list.
 * get and put must both be O(1):
 *   - the HashMap finds a node by key in O(1);
 *   - the doubly linked list keeps the nodes in order of use, newest at the front, so moving a node to the
 *     front or removing the last node takes O(1) too (a node knows its own neighbours).
 * When the cache is full, the node at the back is the least recently used one and is evicted.
 * (systemdesign/LruCacheDemo in the javaconcepts repo shows the same idea with LinkedHashMap.)
 */
public class LruCache {

    private static class Node {
        int key;
        int value;
        Node previous;
        Node next;
    }

    private final int capacity;
    private final Map<Integer, Node> nodes = new HashMap<>();
    private final Node head = new Node();          // sentinel on the "most recently used" side
    private final Node tail = new Node();          // sentinel on the "least recently used" side
    private Integer lastEvicted;

    LruCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }

    private void unlink(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    int get(int key) {
        Node node = nodes.get(key);
        if (node == null) return -1;
        unlink(node);
        addToFront(node);                           // it was just used: move it to the front
        return node.value;
    }

    void put(int key, int value) {
        lastEvicted = null;
        Node node = nodes.get(key);
        if (node != null) {
            node.value = value;
            unlink(node);
            addToFront(node);
            return;
        }
        if (nodes.size() == capacity) {
            Node leastRecentlyUsed = tail.previous;
            unlink(leastRecentlyUsed);
            nodes.remove(leastRecentlyUsed.key);
            lastEvicted = leastRecentlyUsed.key;
        }
        node = new Node();
        node.key = key;
        node.value = value;
        nodes.put(key, node);
        addToFront(node);
    }

    Integer lastEvicted() {
        return lastEvicted;
    }

    /** Keys from most recently used to least recently used. */
    String order() {
        List<Integer> keys = new ArrayList<>();
        for (Node node = head.next; node != tail; node = node.next) keys.add(node.key);
        return keys.toString();
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(2);
        System.out.println("LRUCache(capacity = 2)    order (newest first)");

        cache.put(1, 1);
        System.out.printf("put(1, 1)                 %s%n", cache.order());
        cache.put(2, 2);
        System.out.printf("put(2, 2)                 %s%n", cache.order());
        System.out.printf("get(1) = %-2d               %s%n", cache.get(1), cache.order());
        cache.put(3, 3);
        System.out.printf("put(3, 3) evicts key %-2s   %s%n", cache.lastEvicted(), cache.order());
        System.out.printf("get(2) = %-2d               %s%n", cache.get(2), cache.order());
        cache.put(4, 4);
        System.out.printf("put(4, 4) evicts key %-2s   %s%n", cache.lastEvicted(), cache.order());
        System.out.printf("get(1) = %-2d               %s%n", cache.get(1), cache.order());
        System.out.printf("get(3) = %-2d               %s%n", cache.get(3), cache.order());
        System.out.printf("get(4) = %-2d               %s%n", cache.get(4), cache.order());
    }
}
