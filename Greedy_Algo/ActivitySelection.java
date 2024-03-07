import java.util.ArrayList;

public class ActivitySelection {
    public static void main(String args[]) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 }; // the end time for activities should be sorted or else sort it

        // if end array not sorted ,sort using HashMap

        int maxAxtivity = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int lastEnd = end[0];
        ans.add(0); // all the time begin with 1st ending time
        maxAxtivity++;

        for (int i = 1; i < start.length; i++) {
            if (start[i] >= lastEnd) {
                maxAxtivity++;
                lastEnd = end[i];
                ans.add(i);
            }
        }

        System.out.println("List of Activities index :" + ans);
        System.out.println("Maximum number of Activities can be completed : " + maxAxtivity);

    }
}
