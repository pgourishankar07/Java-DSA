import java.util.ArrayList;
import java.util.Collections;

// to find MST (Minimum Span Tree) 
// the technique is choose the shortest path to the neighbour
// sort the edges
// take min wht edge
// this should not form cycle
// if its forming cycle then dont include the weight
// if there are 5 nodes then their wll be minimum 4 edges
// time : (O(V+E.LogE))
// Before studying this go to Disjoint Set

public class KruskalsAlgo {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wht;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wht = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wht - e2.wht;
        }
    }

    static int n; // no. of vertices
    static int[] par;
    static int[] rank;

    public static void init(ArrayList<Edge> graph) {
        for (Edge i : graph) {
            n = Math.max(i.src, i.dest);
        }
        n = n + 1;
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskal(ArrayList<Edge> graph) {
        init(graph);
        Collections.sort(graph); // 1. sort O(E.LogE) -- based on the edges

        int minWht = 0;
        int count = 0;

        for (int i = 0; count < n - 1; i++) { // O(V) -- boc u need to connect n-1 times
            Edge e = graph.get(i);
            int u = e.src;
            int v = e.dest;
            int wht = e.wht;

            int parA = find(u); // 2. find they are connected or not
            int parB = find(v);

            if (parA != parB) { // not cycle condition then only join the nodes
                union(u, v); // 3. connect the nodes
                minWht += wht;
                count++;
            }

        }

        System.out.println("Minimum Spannin Tree Cost : " + minWht);

    }

    public static void main(String args[]) {

        ArrayList<Edge> graph = new ArrayList<>();

        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));

        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));

        kruskal(graph);
    }
}
