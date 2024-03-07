import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class JobSeq {
    public static void main(String args[]) {
        int jobs[][] = {
                { 4, 20 },
                { 1, 10 },
                { 1, 40 },
                { 1, 30 }
        };

        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1]));

        int maxJobs = 1;
        int time = 1;

        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i][0] > time) {
                maxJobs++;
                time++;
            }
        }

        System.out.println(maxJobs);
    }
}
