//print all subsets of a set of 1st n natural numbers
//it is similar to printing the subsequence of the string

import java.util.ArrayList;
import java.util.List;

public class subsets {

    public static void subSets(int[] arr, int i, List<Integer> list) {
        if (i == arr.length) {
            System.out.println(list);
            return;
        }

        list.add(arr[i]);
        subSets(arr, i + 1, list);
        list.remove(list.size() - 1);
        subSets(arr, i + 1, list);
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3 };
        List<Integer> list = new ArrayList<>();
        subSets(arr, 0, list);
    }
}
