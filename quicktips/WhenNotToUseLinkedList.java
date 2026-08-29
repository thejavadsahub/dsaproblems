package quicktips;

//Author @dsa.java.hub
public class WhenNotToUseLinkedList {

    public static void main(String[] args) {
        int n = 50000;
        java.util.List<Integer> arrayList = new java.util.ArrayList<>();
        java.util.List<Integer> linkedList = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.nanoTime();
        int sum1 = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum1 += arrayList.get(i); // O(1) random access
        }
        long arrayListTime = System.nanoTime() - start;

        start = System.nanoTime();
        int sum2 = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            sum2 += linkedList.get(i); // O(n) random access, O(n^2) overall
        }
        long linkedListTime = System.nanoTime() - start;

        System.out.println("ArrayList random-access loop:  " + arrayListTime / 1_000_000 + " ms");
        System.out.println("LinkedList random-access loop: " + linkedListTime / 1_000_000 + " ms");
    }
}
