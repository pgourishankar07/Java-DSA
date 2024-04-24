import java.util.ArrayList;
import java.util.PriorityQueue;

// to find MST (Minimum Span Tree) -- greedy
// each time picks the smallest edge from unvisited node
public class PrimsAlgo {

    static class Edge {
        int src;
        int dest;
        int wht;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wht = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int wht;

        Pair(int n, int w) {
            node = n;
            wht = w;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.wht - p2.wht;
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean visi[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        int minWht = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visi[curr.node]) {
                visi[curr.node] = true;
                minWht += curr.wht;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int v = e.dest;
                    int wht = e.wht;

                    pq.add(new Pair(v, wht));
                }

            }
        }

        System.out.println("Minimum Spannin Tree Cost : " + minWht);

    }

    public static void main(String args[]) {

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[5];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 2));
        // graph[0].add(new Edge(0, 3, 3));
        // graph[0].add(new Edge(0, 4, 4));

        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 2, 5));
        // graph[1].add(new Edge(1, 4, 7));

        // graph[2].add(new Edge(2, 0, 2));
        // graph[2].add(new Edge(2, 1, 5));
        // graph[2].add(new Edge(2, 3, 6));

        // graph[3].add(new Edge(3, 0, 3));
        // graph[3].add(new Edge(3, 2, 6));

        // graph[4].add(new Edge(4, 0, 4));
        // graph[4].add(new Edge(4, 1, 7));

        prims(graph);
    }
}
