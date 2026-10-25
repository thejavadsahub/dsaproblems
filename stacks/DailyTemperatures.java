package stacks;

//Author @dsa.java.hub
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 739: Daily Temperatures (monotonic stack).
 * For each day, how many days until a warmer one? Keep a stack of the days still waiting for a warmer
 * day; their temperatures only ever go down from bottom to top (a "monotonic" stack). When today is
 * warmer than the day on top, that day has found its answer: pop it and record the distance.
 * Every day is pushed once and popped once, so the whole thing is O(n).
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = new int[temperatures.length];
        Deque<Integer> waiting = new ArrayDeque<>();                 // indexes of days still waiting for a warmer day

        System.out.println("temperatures = " + Arrays.toString(temperatures));
        for (int today = 0; today < temperatures.length; today++) {
            StringBuilder line = new StringBuilder("day " + today + " (" + temperatures[today] + ")");
            while (!waiting.isEmpty() && temperatures[waiting.peek()] < temperatures[today]) {
                int earlier = waiting.pop();
                answer[earlier] = today - earlier;
                line.append("  pops day ").append(earlier).append(" (").append(temperatures[earlier]).append("): wait ")
                        .append(answer[earlier]);
            }
            waiting.push(today);
            line.append("  stack of waiting days: ").append(waiting);
            System.out.println(line);
        }
        System.out.println("days that never see a warmer day stay 0");
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
