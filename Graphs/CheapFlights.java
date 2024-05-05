import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapFlights {

    static class Edge {
        int src;
        int dest;
        int wht;

        Edge(int s, int d) {
            src = s;
            dest = d;
            wht = 1;
        }

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wht = w;
        }
    }

    static class Pair {
        int node;
        int wht;
        int stops;

        Pair(int n, int w, int s) {
            node = n;
            wht = w;
            stops = s;
        }
    }

    public static int cheapFlights(ArrayList<Edge> graph[], int src, int dest, int k) {
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.remove();

            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.node].size(); i++) {
                Edge e = graph[curr.node].get(i);
                // int u = e.src;
                int v = e.dest;
                int wt = e.wht;

                if (curr.wht + wt < dist[v] && curr.stops <= k) { // we use this curr.wht bcoz of corner case orelse we
                                                                  // would have used dijKistras algo
                    dist[v] = curr.wht + wt;
                    q.add(new Pair(v, dist[v], curr.stops + 1));
                }

            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];

    }

    public static void main(String args[]) {
        int src = 0, dest = 3, k = 1;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[4];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 100));

        graph[1].add(new Edge(1, 3, 600));
        graph[1].add(new Edge(1, 2, 200));

        graph[2].add(new Edge(2, 0, 100));
        graph[2].add(new Edge(2, 3, 200));

        System.out.println(cheapFlights(graph, src, dest, k));

        /*
         * Corner TestCase
         * n =
         * 4
         * flights =
         * [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
         * src =
         * 0
         * dst =
         * 3
         * k =
         * 1
         * 
         * Output
         * 3
         * Expected
         * 6
         */

    }
}
