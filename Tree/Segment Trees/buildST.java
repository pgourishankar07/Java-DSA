public class buildST {

    static int tree[];

    public static void ST(int n) {
        tree = new int[4 * n];
    }

    // CREATION_______//______//_________//_____________
    public static int build(int[] nodes, int i, int start, int end) {
        if (start == end) {
            tree[i] = nodes[start];
            return nodes[start];
        }

        int mid = (start + end) / 2;

        build(nodes, 2 * i + 1, start, mid);
        build(nodes, 2 * i + 2, mid + 1, end);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];

        return tree[i];
    }

    // QUERY_______//______//_________//_____________

    public static int getSum(int[] nodes, int qi, int qj) {
        int n = nodes.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    // si - segement index
    // qi - query index
    // which segment lies between the queries, we add that nodes val
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if (qi > sj || qj < si) { // no overlap -- out of range from the segment
            return 0;
        } else if ((qi <= si && qj >= sj)) { // complete overlap condition -- segment inside the query
            return tree[i];
        } else { // half overlap
            int mid = (si + sj) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);

            return left + right;
        }
    }

    // UPDATE_______//______//_________//_____________

    public static void update(int[] nodes, int idx, int newVal) {
        int n = nodes.length;
        int diff = newVal - nodes[idx];

        nodes[idx] = newVal; // update that node
        updateUtil(0, 0, n - 1, idx, diff); // update the ST
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        if (idx < si || idx > sj) { // out of range
            return;
        }

        tree[i] += diff;

        if (si != sj) { // until reachinf leaf nodes
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, diff);
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff);
        }
    }

    public static void main(String args[]) {

        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = nodes.length;

        ST(n);
        build(nodes, 0, 0, n - 1);

        for (int i : tree) {
            System.out.print(i + " ");
        }
        System.out.println();

        // _______//______//_________//_____________

        System.out.println(getSum(nodes, 0, 0));

        // _______//______//_________//_____________
        // update(nodes, 2, 2);
        // System.out.println(getSum(nodes, 2, 5));

    }
}
