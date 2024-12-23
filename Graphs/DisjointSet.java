public class DisjointSet {

    static int n;
    static int[] par = new int[n];
    static int[] rank = new int[n]; // store the height of the graph

    public static void init(int num) {
        n = num;
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) { // find parent of the node -- recursively finds the main parent of the nodes
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]); // path compression so no unecessary calls upto top
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) { // whose height is more joining to that parent (which parent is more rich)
            par[parB] = parA; // joining the B to group A
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void main(String args[]) {
        init(7);

        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}
