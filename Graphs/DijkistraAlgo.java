import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// Find shortest path from source to all the nodes
public class DijkistraAlgo {
    // it is Greedy based
    static class Edge {
        int src;
        int dest;
        int wht;

        Edge(int s, int d, int e) {
            src = s;
            dest = d;
            wht = e;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        Pair(int n, int p) {
            node = n;
            path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkistra(ArrayList<Edge>[] graph, int src) { // O(V + E.LogV)
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean[] visi = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visi[curr.node]) {
                visi[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wht = e.wht;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wht < dist[v]) { // dist[u] if MAX_VALUE then adding
                                                                                   // any no. to it will be negative
                        dist[v] = dist[u] + wht;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        System.out.println("Shortest Distance from Source to all the nodes");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("From " + src + " To " + i + " : " + dist[i]);
        }

    }

    public static void main(String argsp[]) {

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];

        // initial ArryaList in each node to store their connections
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        dijkistra(graph, 0);

    }
}
