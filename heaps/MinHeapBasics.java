package heaps;

//Author @dsa.java.hub
public class MinHeapBasics {

    private int[] data;
    private int size;

    MinHeapBasics(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    void insert(int value) {
        data[size] = value;
        int i = size;
        size++;

        while (i > 0) {
            int parent = (i - 1) / 2;
            if (data[parent] <= data[i]) break;
            int temp = data[parent];
            data[parent] = data[i];
            data[i] = temp;
            i = parent;
        }
    }

    public static void main(String[] args) {
        MinHeapBasics heap = new MinHeapBasics(10);
        int[] values = {50, 30, 70, 20, 40, 10};
        for (int v : values) {
            heap.insert(v);
        }
        System.out.println("Heap array: " + java.util.Arrays.toString(java.util.Arrays.copyOf(heap.data, heap.size)));
        System.out.println("Min (root, index 0): " + heap.data[0]);
    }
}
