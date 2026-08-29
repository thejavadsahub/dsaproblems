package quicktips;

//Author @dsa.java.hub
public class ArraysSortVsCollectionsSort {

    public static void main(String[] args) {
        int[] primitives = {5, 2, 9, 1, 5, 6};
        java.util.Arrays.sort(primitives);
        System.out.println("Arrays.sort() on int[]: " + java.util.Arrays.toString(primitives));

        java.util.List<Integer> list = new java.util.ArrayList<>(java.util.List.of(5, 2, 9, 1, 5, 6));
        java.util.Collections.sort(list);
        System.out.println("Collections.sort() on List<Integer>: " + list);
    }
}
