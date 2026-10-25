package graphs;

//Author @dsa.java.hub
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode 207 / 210: Course Schedule, topological sort with Kahn's algorithm.
 * An edge a -> b means "take a before b". Count how many prerequisites each course still has
 * (its in-degree). Courses with 0 are ready: take one, and every course that needed it has one
 * prerequisite fewer. If every course gets taken there is no cycle and the order is a valid schedule.
 */
public class CourseScheduleTopoSort {

    public static void main(String[] args) {
        String[] courses = {"Java", "SQL", "DSA", "OOP", "Spring", "Interviews"};
        int[][] prerequisites = {{0, 2}, {0, 3}, {3, 4}, {1, 4}, {2, 5}, {4, 5}};   // {before, after}

        List<List<Integer>> unlocks = new ArrayList<>();          // course -> courses that need it
        int[] inDegree = new int[courses.length];
        for (int i = 0; i < courses.length; i++) unlocks.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            unlocks.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        System.out.println("in-degree " + Arrays.toString(inDegree));

        Deque<Integer> ready = new ArrayDeque<>();
        for (int i = 0; i < courses.length; i++) {
            if (inDegree[i] == 0) ready.add(i);
        }

        List<String> order = new ArrayList<>();
        while (!ready.isEmpty()) {
            int course = ready.poll();
            order.add(courses[course]);

            StringBuilder updates = new StringBuilder();
            for (int next : unlocks.get(course)) {
                inDegree[next]--;
                updates.append(courses[next] + "->" + inDegree[next] + " ");
                if (inDegree[next] == 0) ready.add(next);
            }
            List<String> waiting = new ArrayList<>();
            for (int c : ready) waiting.add(courses[c]);
            System.out.println("take " + courses[course] + " | " + updates + "| queue " + waiting);
        }
        System.out.println("order " + order + " (" + order.size() + "/" + courses.length + " -> "
                + (order.size() == courses.length ? "no cycle" : "cycle") + ")");
    }
}
