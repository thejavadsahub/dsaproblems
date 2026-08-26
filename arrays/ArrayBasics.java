package arrays;

//Author @dsa.java.hub
public class ArrayBasics {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 95, 60};

        for (int i = 0; i < scores.length; i++) {
            System.out.println("Index " + i + ": " + scores[i]);
        }

        int total = 0;
        for (int s : scores) {
            total += s;
        }
        System.out.println("Total: " + total);
    }
}
