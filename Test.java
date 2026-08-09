import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

class Solution {
    public static int[] finalPrices(int[] prices) {

        int n = prices.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            System.out.println(stk);
            if (stk.isEmpty()) {
                ans[i] = prices[i];
                stk.push(prices[i]);
                continue;
            }

            if (stk.peek() > prices[i]) {
                while (stk.isEmpty() && stk.peek() > prices[i]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    ans[i] = prices[i];
                    stk.push(prices[i]);
                    continue;
                }
            }

            ans[i] = prices[i] - stk.peek();
            stk.push(prices[i]);

        }

        return ans;
    }
}

public class Test {
    public static void main(String[] args) {
        // int prices[] = { 8, 4, 6, 2, 3 };

        // int ans[] = new int[prices.length];
        // ans = Solution.finalPrices(prices);

        System.out.println(15 >> 3);
        System.out.println(15 / 3);

        // LinkedHashMap<LinkedList<Integer>, Integer> stk = new Hashtable<>();

    }
}
