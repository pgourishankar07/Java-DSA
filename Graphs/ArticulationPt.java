import java.util.ArrayList;

// Finding which node to remove so that we divide the graph into components(undirected graph)
public class ArticulationPt {

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

    public static void articulationPt(ArrayList<Edge>[] graph) {
        int n = graph.length;
        int dt[] = new int[n];
        int low[] = new int[n];
        int time = 0;
        boolean visi[] = new boolean[n];
        boolean ap[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visi[i]) {
                dfs(graph, i, -1, time, dt, low, visi, ap);
            }
        }

        for (int i = 0; i < ap.length; i++) {
            if (ap[i]) {
                System.out.println("Articulation Point : " + i);

            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int time, int[] dt, int low[], boolean[] visi,
            boolean[] ap) {

        visi[curr] = true;
        dt[curr] = low[curr] = ++time;
        int child = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (neigh == par) {
                continue;
            } else if (!visi[neigh]) {
                dfs(graph, neigh, curr, time, dt, low, visi, ap);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }

                child++;

            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }

        if (par == -1 && child > 1) {
            ap[curr] = true;
        }
    }

    public static void main(String args[]) {

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[5];

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

        articulationPt(graph);

        /*
         
         */
    }
}
