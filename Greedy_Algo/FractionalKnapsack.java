import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String args[]) {

        int val[] = { 60, 100, 120 };
        int wht[] = { 10, 20, 30 };
        int capacity = 50;

        double ratio[][] = new double[val.length][2];

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) (val[i] / wht[i]);
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int maxVal = 0;

        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity < wht[idx]) {
                maxVal += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
            maxVal += val[idx];
            capacity -= wht[idx];
        }

        System.out.println(maxVal);
    }
}
