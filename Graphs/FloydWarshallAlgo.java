/**
 * FloydWarshallAlgo
 */
public class FloydWarshallAlgo {

    final static int INF = 99999;
    final static int V = 4;

    public static void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist);
    }

    public static void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = {
                { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
        };

        // Vertex 0: (0) --5--> (1), (0) --10--> (3)
        // Vertex 1: (1) --INF--> (0), (1) --3--> (2)
        // Vertex 2: (2) --INF--> (0), (2) --INF--> (1), (2) --1--> (3)
        // Vertex 3: (3) --INF--> (0), (3) --INF--> (1), (3) --INF--> (2)

        floydWarshall(graph);

    }

}