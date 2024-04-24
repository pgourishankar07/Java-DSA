import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Creation {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d) {
            src = s;
            dest = d;
            wt = 1;
        }

        Edge(int s, int d, int e) {
            src = s;
            dest = d;
            wt = e;
        }
    }

    // Get the nighbours of a node// _________// _________//// _________//
    public static void getNext(ArrayList<Edge> graph[], int node) {
        for (int i = 0; i < graph[node].size(); i++) {
            System.out.println(graph[node].get(i).dest);
        }
    }

    // BFS -- using Queue (immediate neighbours 1st)// _________// _________//
    public static void bfs(ArrayList<Edge> graph[]) {

        boolean[] visi = new boolean[graph.length];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.remove();

            if (!visi[node]) { // 1. check visi or not
                System.out.println(node); // 2. print
                visi[node] = true; // 3. mark visted

                // 4. add there neighbours
                for (int i = 0; i < graph[node].size(); i++) {
                    int temp = graph[node].get(i).dest;
                    q.add(temp);
                }
            }
        }
    }

    // DFS -- using Stack / Recursion(implicit Stack)// _________// _________//
    public static void dfs(ArrayList<Edge> graph[], int node, boolean[] visi) {
        System.out.println(node);
        visi[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int curr = graph[node].get(i).dest;
            if (!visi[curr]) {
                dfs(graph, curr, visi);
            }
        }
    }

    // Has Path from src to dest// _________// _________//// _________// _________//
    public static void hasPath(ArrayList<Edge> graph[], int src, int dest, boolean[] visi) {
        if (src == dest) {
            System.out.println("Reached " + src);
            visi[src] = true;
            return;
        }

        visi[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            int curr = graph[src].get(i).dest;
            if (!visi[curr]) {
                hasPath(graph, curr, dest, visi);
            }
        }
    }

    public static boolean hasPathh(ArrayList<Edge> graph[], int src, int dest, boolean[] visi) {
        if (src == dest) {
            return true;
        }

        visi[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            int curr = graph[src].get(i).dest;
            if (!visi[curr] && hasPathh(graph, curr, dest, visi)) {
                return true;
            }
        }

        return false;
    }

    // Connected Components// _________// _________//// _________// _________//
    public static void connectedCompDfs(ArrayList<Edge> graph[]) {
        boolean[] visi = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visi[i]) {
                dfs(graph, i, visi);
            }
        }
    }

    public static void connectedCompBfs(ArrayList<Edge> graph[]) {
        boolean[] visi = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visi[i]) {
                bfsUtil(graph, visi, i);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean[] visi, int j) {
        Queue<Integer> q = new LinkedList<>();
        q.add(j);

        while (!q.isEmpty()) {
            int node = q.remove();

            if (!visi[node]) {
                System.out.println(node);
                visi[node] = true;

                for (int i = 0; i < graph[node].size(); i++) {
                    int temp = graph[node].get(i).dest;
                    q.add(temp);
                }
            }
        }
    }

    // Cycles in Graph DFS// _________// _________//// _________// _________//
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visi[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visi[i]) {
                if (detectCycleUtil(graph, visi, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visi, int node, int par) {
        visi[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int temp = graph[node].get(i).dest;
            if (!visi[temp]) {
                if (detectCycleUtil(graph, visi, temp, node)) { // recursion part
                    return true;
                }
            } else if (visi[temp] && temp != par) { // base case
                return true;
            } else if (visi[temp] && temp == par) {
                continue; // checking while backtracking
            }
        }

        return false;
    }

    // Cycles in Graph BFS// _________// _________//// _________// _________//
    public static boolean detectCycleBfs(ArrayList<Edge> graph[]) {
        boolean visi[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visi[i] && detectCycleBfsUtil(graph, i, visi))
                return true;
        }

        return false;
    }

    public static boolean detectCycleBfsUtil(ArrayList<Edge> graph[], int s, boolean visi[]) {
        int parent[] = new int[graph.length];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        visi[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.remove();

            for (int i = 0; i < graph[u].size(); i++) {
                int v = graph[u].get(i).dest;

                if (!visi[v]) {
                    visi[v] = true;
                    q.add(v);
                    parent[v] = u;
                } else if (parent[u] != v) { // if any node node has 2 different parent
                    return true;
                }
            }
        }

        return false;
    }

    // Detect Cycle in Directed Graph_______________//_______________
    public static boolean detectDirCycle(ArrayList<Edge> graph[]) {
        boolean visi[] = new boolean[graph.length];
        boolean stk[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visi[i]) {
                if (detectDirCycleUtil(graph, i, visi, stk)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectDirCycleUtil(ArrayList<Edge> graph[], int node, boolean[] visi, boolean[] stk) {
        visi[node] = true;
        stk[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int temp = graph[node].get(i).dest;

            if (stk[temp]) { // cycle exists
                return true;
            }

            if (!visi[temp] && detectDirCycleUtil(graph, temp, visi, stk)) {
                return true;
            }
        }

        stk[node] = false;
        return false;
    }

    // BiPartite graph or not _________// _________// _________// _________//
    public static boolean biPartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int node = q.remove();

                    for (int j = 0; j < graph[node].size(); j++) {
                        int temp = graph[node].get(j).dest;

                        if (color[temp] == -1) {
                            color[temp] = color[node] == 0 ? 1 : 0; // toggle color
                            q.add(temp);
                        } else if (color[node] == color[temp]) {
                            return false;
                        }

                    }
                }
            }
        }

        return true;

    }

    // Topological SortingBFS_________// _________// _________// _________//
    public static void topologicalSortBFS(ArrayList<Edge> graph[]) {
        boolean[] visi = new boolean[graph.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visi[i]) {
                topoSortUtilBFS(graph, i, visi, stk);
            }
        }

        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }

    public static void topoSortUtilBFS(ArrayList<Edge> graph[], int node, boolean[] visi, Stack<Integer> stk) {
        visi[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int temp = graph[node].get(i).dest;

            if (!visi[temp]) {
                topoSortUtilBFS(graph, temp, visi, stk);
            }
        }

        stk.push(node);
    }

    // InDegree Calculator___________//___________//_____________
    public static void inDegCal(ArrayList<Edge>[] graph, int inDeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int node = i;
            for (int j = 0; j < graph[node].size(); j++) {
                int temp = graph[node].get(j).dest;
                inDeg[temp]++;
            }
        }
    }

    // OutDegree Calculator___________//___________//_____________
    public static void outDegCal(ArrayList<Edge>[] graph, int outDeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int node = i;
            outDeg[node] = graph[node].size();
        }
    }

    // Topological SortingBFS_________// _________// _________// _________//
    public static void topologicalSortDFS(ArrayList<Edge> graph[]) {
        int inDeg[] = new int[graph.length];
        inDegCal(graph, inDeg);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDeg.length; i++) { // calculate for 1st time
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + " ");

            for (int i = 0; i < graph[node].size(); i++) {
                int temp = graph[node].get(i).dest;
                inDeg[temp]--;

                if (inDeg[temp] == 0) {
                    q.add(temp);
                }
            }
        }
    }

    // All Paths From Source to Destination(similar to has path)// _________//
    public static void allPath(ArrayList<Edge>[] graph, boolean[] visited, int s, int d, String path) {
        visited[s] = true;
        if (s == d) {
            System.out.println(path + Integer.toString(s));
            return;
        }
        for (int i = 0; i < graph[s].size(); i++) {
            int curr = graph[s].get(i).dest;
            if (!visited[curr]) {
                allPath(graph, visited, curr, d, path + Integer.toString(s) + " -> ");
            }
        }
        visited[s] = false;
    }

    // _________// _________// _________// _________// _________// _________//
    // _________// _________// _________// _________// _________// _________//

    public static void main(String args[]) {

        // _________// _________// _________// _________// _________// _________//

        // creating Array to store nodes
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];

        // initial ArryaList in each node to store their connections
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 1, 1));

        // getNext(graph, 3);
        System.out.println();

        // _________// _________// _________// _________// _________// _________//

        // creating Array to store nodes
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph2 = new ArrayList[7];

        // initial ArryaList in each node to store their connections
        for (int i = 0; i < graph2.length; i++) {
            graph2[i] = new ArrayList<>();
        }

        graph2[0].add(new Edge(0, 1, 5));
        graph2[0].add(new Edge(0, 2, 5));

        graph2[1].add(new Edge(1, 0, 5));
        graph2[1].add(new Edge(1, 3, 3));

        graph2[2].add(new Edge(2, 0, 1));
        graph2[2].add(new Edge(2, 4, 4));

        graph2[3].add(new Edge(3, 1, 3));
        graph2[3].add(new Edge(3, 4, 3));
        graph2[3].add(new Edge(3, 5, 1));

        graph2[4].add(new Edge(4, 2, 1));
        graph2[4].add(new Edge(4, 3, 1));
        graph2[4].add(new Edge(4, 5, 1));

        graph2[5].add(new Edge(5, 3, 1));
        graph2[5].add(new Edge(5, 4, 1));
        graph2[5].add(new Edge(5, 6, 1));

        graph2[6].add(new Edge(6, 5, 1));

        // _________// _________// _________// _________// _________// _________//
        // bfs(graph2);
        System.out.println();
        // _________// _________// _________// _________// _________// _________//
        // dfs(graph2, 0, new boolean[graph2.length]);

        // _________// _________// _________// _________// _________// _________//
        // hasPath(graph2, 0, 5, new boolean[graph2.length]);
        // hasPath(graph2, 0, 7, new boolean[graph2.length]);
        // System.out.println(hasPathh(graph2, 0, 5, new boolean[graph2.length]));

        // _________// _________// _________// _________// _________// _________//

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph3 = new ArrayList[5];

        for (int i = 0; i < graph3.length; i++) {
            graph3[i] = new ArrayList<>();
        }

        graph3[0].add(new Edge(0, 1, 5));
        // graph2[0].add(new Edge(0, 2, 5));

        graph3[1].add(new Edge(1, 0, 5));
        graph3[1].add(new Edge(1, 3, 3));

        // graph2[2].add(new Edge(2, 0, 1));
        graph3[2].add(new Edge(2, 4, 4));

        // connectedCompDfs(graph3);
        // connectedCompBfs(graph3);

        // ________________// ________________// ________________// ________________
        // System.out.println(detectCycle(graph2));
        // System.out.println(detectCycle(graph3));
        // System.out.println(detectCycleBfs(graph3));
        // ________________// ________________// ________________// ________________

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph4 = new ArrayList[5];

        for (int i = 0; i < graph4.length; i++) {
            graph4[i] = new ArrayList<>();
        }

        graph4[0].add(new Edge(0, 1));
        graph4[0].add(new Edge(0, 2));

        graph4[1].add(new Edge(1, 0));
        graph4[1].add(new Edge(1, 3));

        graph4[2].add(new Edge(2, 0));
        graph4[2].add(new Edge(2, 4));

        graph4[3].add(new Edge(3, 1));
        graph4[3].add(new Edge(3, 4));

        graph4[4].add(new Edge(4, 2));
        graph4[4].add(new Edge(4, 3));

        // System.out.println(biPartite(graph4));

        // _________// _________// _________// _________// _________// _________//

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph5 = new ArrayList[5];

        for (int i = 0; i < graph5.length; i++) {
            graph5[i] = new ArrayList<>();
        }

        graph5[0].add(new Edge(0, 2));
        graph5[1].add(new Edge(1, 0));
        graph5[2].add(new Edge(2, 3));
        graph5[3].add(new Edge(3, 0));

        // graph5[0].add(new Edge(0, 1));
        // graph5[0].add(new Edge(0, 2));
        // graph5[1].add(new Edge(1, 3));
        // graph5[2].add(new Edge(2, 3));

        // System.out.println(detectDirCycle(graph5));

        // _________// _________// _________// _________// _________// _________//

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph6 = new ArrayList[6];

        for (int i = 0; i < graph6.length; i++) {
            graph6[i] = new ArrayList<>();
        }

        // graph6[0].add(new Edge(0, 3));
        graph6[2].add(new Edge(2, 3));

        graph6[3].add(new Edge(3, 1));

        graph6[4].add(new Edge(4, 0));
        graph6[4].add(new Edge(4, 1));

        graph6[5].add(new Edge(5, 0));
        graph6[5].add(new Edge(5, 2));

        System.out.println(detectDirCycle(graph6));

        // topologicalSortBFS(graph6);
        topologicalSortDFS(graph6);
        System.out.println();

    }
}
