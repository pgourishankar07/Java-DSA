import java.util.ArrayList;
import java.util.Arrays;

// to Find shorrtest path from source to all the nodes(includes neagative edges)
public class BellmanAlgo {
    // it is DP based // (Time Complexity :(O(VE))) // but its doenst work for
    // negative weighted cycle graphs because if sum of the edges of that cycle

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

    public static void bellman(ArrayList<Edge>[] graph, int src) { // O(V.E)
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < graph.length - 1; i++) { // repeat iteration for nodes-1// times //O(V) src is not included

            for (int node = 0; node < graph.length; node++) { // O(E) // for each node

                for (int k = 0; k < graph[node].size(); k++) { // visit their neighbours
                    Edge e = graph[node].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wht = e.wht;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wht < dist[v]) {
                        dist[v] = dist[u] + wht;
                    }
                }
            }

        }

        System.out.println("Shortest Distance from Source to all the nodes");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("From " + src + " To " + i + " : " + dist[i]);
        }

    }

    public static void main(String args[]) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

        bellman(graph, 0);

    }
}
