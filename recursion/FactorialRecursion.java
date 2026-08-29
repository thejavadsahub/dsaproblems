package recursion;

//Author @dsa.java.hub
public class FactorialRecursion {

    static long factorial(int n) {
        if (n == 0 || n == 1) return 1; // base case
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = 6;
        System.out.println(num + "! = " + factorial(num));
    }
}
