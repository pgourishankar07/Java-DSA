import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StronConnComp {
    // SCC is a componenet in which we can reach any node of the component through
    // any no. of nodes (directed graph)

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

    public static void topoSort(ArrayList<Edge> graph[], int curr, boolean visi[], Stack<Integer> stk) {
        visi[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            int node = graph[curr].get(i).dest;
            if (!visi[node]) {
                topoSort(graph, node, visi, stk);
            }
        }

        stk.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visi[]) {
        visi[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            int node = graph[curr].get(i).dest;
            if (!visi[node]) {
                dfs(graph, node, visi);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[]) {
        // Step 1: Perform Topological Sorting
        Stack<Integer> stk = new Stack<>();
        boolean visi[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visi[i]) {
                topoSort(graph, i, visi, stk);
            }
        }

        // Step 2: Transpose the graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge> trans[] = new ArrayList[graph.length];
        for (int i = 0; i < graph.length; i++) {
            trans[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                trans[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3: Perform DFS on transposed graph using stk order
        Arrays.fill(visi, false);
        while (!stk.isEmpty()) {
            int node = stk.pop();
            if (!visi[node]) {
                dfs(trans, node, visi);
                System.out.println();
            }
        }
    }

    // in this, order will be wrong but it gives SCC(reverse DFS)
    public static void miniKosaraju(ArrayList<Edge> graph[]) {
        boolean[] visi = new boolean[graph.length];
        for (int i = graph.length - 1; i >= 0; i--) {
            if (!visi[i]) {
                dfs(graph, i, visi);
            }
            System.out.println();
        }
    }
    // ______________________________
    // My custom miniKosaraju

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visi[], ArrayList<Integer> list) {
        visi[curr] = true;
        list.add(0, curr);

        for (int i = 0; i < graph[curr].size(); i++) {
            int node = graph[curr].get(i).dest;
            if (!visi[node]) {
                dfs(graph, node, visi, list);
            }
        }
    }

    public static void myMiniKosaraju(ArrayList<Edge> graph[]) {
        boolean[] visi = new boolean[graph.length];
        Stack<ArrayList<Integer>> stk = new Stack<>();
        for (int i = graph.length - 1; i >= 0; i--) {
            ArrayList<Integer> list = new ArrayList<>();
            if (!visi[i]) {
                dfs(graph, i, visi, list);
            }
            if (list.size() != 0) {
                stk.push(list);
            }
        }

        while (!stk.isEmpty()) {
            System.out.println(stk.pop());
        }
    }

    public static void main(String args[]) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[5];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

        miniKosaraju(graph);
        System.out.println("______");
        kosaraju(graph);
        System.out.println("______");
        myMiniKosaraju(graph);
    }
}
