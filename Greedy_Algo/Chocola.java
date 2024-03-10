import java.util.Arrays;
import java.util.Collections;

public class Chocola {
    public static void main(String args[]) {

        // chocolate bar
        // int n = 4;
        // int m = 6;
        int cost = 0;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int v = 0, h = 0;
        int vp = 1, hp = 1;

        while (v < costVer.length && h < costHor.length) {
            if (costVer[v] <= costHor[h]) {
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }
        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        System.out.println(cost);
        ;
    }
}
