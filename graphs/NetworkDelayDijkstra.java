package graphs;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 743: Network Delay Time (Dijkstra's shortest paths).
 * A priority queue always hands out the closest unfinished node. When a node is finalized, try to
 * improve the distance of each neighbour ("relax" the edge). Better distances are pushed again, so
 * older entries for the same node become stale and are skipped when they come out.
 * The network delay is the largest shortest distance from the start node A.
 */
public class NetworkDelayDijkstra {

    public static void main(String[] args) {
        String names = "ABCDEF";
        int[][] edges = {{0, 1, 4}, {0, 2, 1}, {2, 1, 2}, {2, 3, 5}, {2, 5, 8},
                         {1, 3, 1}, {1, 4, 6}, {3, 4, 3}, {3, 5, 2}};              // {from, to, time}
        int n = names.length();

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) graph.get(edge[0]).add(new int[]{edge[1], edge[2]});

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        boolean[] finalized = new boolean[n];

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.<int[]>comparingInt(entry -> entry[0]).thenComparingInt(entry -> entry[1]));   // {distance, node}
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int node = entry[1];
            if (finalized[node]) {
                System.out.println("pop stale (" + entry[0] + "," + names.charAt(node) + ") skip");
                continue;
            }
            finalized[node] = true;

            StringBuilder line = new StringBuilder("pop " + names.charAt(node) + "=" + entry[0] + " |");
            for (int[] edge : graph.get(node)) {
                int neighbour = edge[0];
                int candidate = distance[node] + edge[1];
                if (candidate < distance[neighbour]) {
                    String before = distance[neighbour] == Integer.MAX_VALUE ? "inf" : String.valueOf(distance[neighbour]);
                    line.append(" " + names.charAt(neighbour) + ":" + before + "->" + candidate);
                    distance[neighbour] = candidate;
                    queue.add(new int[]{candidate, neighbour});
                } else {
                    line.append(" " + names.charAt(neighbour) + ":" + candidate + " no (" + distance[neighbour] + ")");
                }
            }
            System.out.println(line);
        }
        System.out.println("dist " + Arrays.toString(distance)
                + " network delay = " + Arrays.stream(distance).max().getAsInt());
    }
}
