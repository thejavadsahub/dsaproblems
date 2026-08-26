package quicktips;

//Author @dsa.java.hub
//Quick tip 💡
public class StringBuilderVsConcat {
    public static void main(String[] args) {
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(i);
        }

        System.out.println("Concat result: " + result);
        System.out.println("Builder result: " + sb.toString());
    }
}