import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problems {

    // Weakest Soldier
    static class ArrayWithIndex {
        int[] array;
        int index;

        public ArrayWithIndex(int[] array, int index) {
            this.array = array;
            this.index = index;
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {

        int n = mat.length;

        Comparator<ArrayWithIndex> comp = new Comparator<>() {
            public int compare(ArrayWithIndex i, ArrayWithIndex j) {
                int counti = 0;
                int countj = 0;
                for (int x = 0; x < i.array.length; x++) {
                    if (i.array[x] == 1) {
                        counti++;
                    }
                    if (j.array[x] == 1) {
                        countj++;
                    }
                }

                if (counti > countj) {
                    return 1;
                } else if (counti < countj) {
                    return -1;
                } else {
                    if (i.index > j.index) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };

        PriorityQueue<ArrayWithIndex> pq = new PriorityQueue<>(comp);

        for (int i = 0; i < n; i++) {
            pq.add(new ArrayWithIndex(mat[i], i));
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().index;
        }

        return res;

    }

    // NearBy cars
    public int[][] kClosest(int[][] points, int k) {

        Comparator<int[]> comp = new Comparator<>() {
            public int compare(int[] i, int[] j) {
                int val1 = (i[0] * i[0]) + (i[1] * i[1]);
                int val2 = (j[0] * j[0]) + (j[1] * j[1]);
                if (val1 > val2) {
                    return 1;
                } else if (val1 < val2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);

        for (int[] i : points) {
            pq.add(i);
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }

        return res;
    }

    // RopesCount
    public static int connectRopes(int[] ropes) {
        int cost = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : ropes) {
            pq.add(i);
        }

        while (pq.size() > 1) {
            int val1 = pq.poll();
            int val2 = pq.poll();

            cost += val1 + val2;

            pq.add(val1 + val2);
        }

        return cost;
    }

    // Sliding Window Maximum
    class ArrayIdx {
        int val;
        int index;

        ArrayIdx(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<ArrayIdx> pq = new PriorityQueue<>((a, b) -> b.val - a.val);

        for (int i = 0; i < k; i++) {
            pq.add(new ArrayIdx(nums[i], i));
        }

        res[0] = pq.peek().val;
        int ptr = 1;

        for (int i = k; i < n; i++) {
            pq.add(new ArrayIdx(nums[i], i));
            while (pq.peek().index <= i - k) {
                pq.remove();
            }
            res[ptr] = pq.peek().val;
            ptr++;
        }

        return res;

    }

    // kth Largest Element
    class KthLargest {

        int k;
        PriorityQueue<Integer> pq;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (pq.size() < k) {
                pq.add(val);
            } else if (pq.peek() < val) {
                pq.remove();
                pq.add(val);
            }
            return pq.peek();
        }
    }

    public static void minTime(int arr[], int N) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[N + 1];
        int time = 0;

        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
            vis[arr[i]] = true;
        }

        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                int curr = q.poll();
                if (curr - 1 >= 1 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.add(curr - 1);
                }
                if (curr + 1 <= N && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
            time++;
        }

        System.out.println(time - 1);
    }

    public static void main(String args[]) {
        int ropes[] = { 3, 2, 4, 3, 6 };

        System.out.println(connectRopes(ropes));
    }
}
