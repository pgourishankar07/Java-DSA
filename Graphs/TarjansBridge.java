import java.util.ArrayList;

// Finding which bridge to break so that we divide the graph into components(undirected graph)
public class TarjansBridge {

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

    public static void tarjansBridge(ArrayList<Edge>[] graph) {
        int n = graph.length;
        int dt[] = new int[n]; // discovery time
        int low[] = new int[n]; // lowest discovery of all neighbours(including node)
        int time = 0;
        boolean visi[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visi[i]) {
                dfs(graph, i, -1, time, dt, low, visi);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int time, int[] dt, int low[], boolean[] visi) {

        visi[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (neigh == par) { // cycle condition
                continue;
            } else if (!visi[neigh]) { // if node is not visited then call dfs
                dfs(graph, neigh, curr, time, dt, low, visi);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (dt[curr] < low[neigh]) { // bridge condition -- if discovery time of node is greater then it has
                                             // been travelled from other way through v to u
                    System.out.println("Bridge : " + curr + "----" + neigh);
                }

            } else { // if neighbour is visited then there is defenitely another way, store the lower
                     // discovery time -- that is lowest(all discovery time of neighbours)
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void main(String args[]) {

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[6];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));

        tarjansBridge(graph);

        /*
         * When the neighbor neigh is not visited (!visi[neigh]):
         * 
         * After recursively exploring the neighbor neigh, we update low[curr] to be the
         * minimum of its current value and the lowest discovery time (low[neigh])
         * reachable from neigh.
         * This ensures that low[curr] reflects the lowest discovery time reachable from
         * both the current node's children and its unvisited neighbors.
         * When the neighbor neigh is already visited (else block):
         * 
         * In this case, we update low[curr] to be the minimum of its current value and
         * the discovery time (dt[neigh]) of the visited neighbor neigh.
         * This ensures that low[curr] considers all the edges leading to neigh,
         * including back edges (edges to ancestors in the DFS tree), to calculate the
         * lowest reachable discovery time.
         */
    }
}
