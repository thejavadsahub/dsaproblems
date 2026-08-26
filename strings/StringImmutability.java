package strings;

//Author @dsa.java.hub
public class StringImmutability {
    public static void main(String[] args) {
        String a = "hello";
        String b = a;

        a = a + " world";  // creates a NEW string object, doesn't modify original

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("Same object? " + (a == b));
    }
}