package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
public class MissingBaseCaseBug {

    static long factorial(int n) {
        return n * factorial(n - 1); // BUG: no base case, recursion never stops
    }

    public static void main(String[] args) {
        System.out.println(factorial(6));
    }
}
