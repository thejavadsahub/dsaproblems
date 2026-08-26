package quicktips;

//Author @dsa.java.hub
//Quick tip 💡
import java.util.ArrayList;

public class ArrayVsArrayList {
    public static void main(String[] args) {
        int[] fixedArray = new int[5];
        fixedArray[0] = 10;

        ArrayList<Integer> dynamicList = new ArrayList<>();
        dynamicList.add(10);
        dynamicList.remove(0);

        System.out.println("Array[0]: " + fixedArray[0]);
        System.out.println("List after remove: " + dynamicList);
    }
}