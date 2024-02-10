//To get maximum in an subarray 
//when there are -ve numbers in the starting of an array we consider it as 0.
public class KadaneAlgo {
    public static void main(String args[]) {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int currSum = 0;
        int maxSum = 0;
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0 && flag == 0) {
                currSum += 0;
                continue;
            } else {
                flag = 1;
            }
            currSum += arr[i];
            maxSum = currSum > maxSum ? currSum : maxSum;
        }
        System.out.println("Maximum : " + maxSum);
    }
}
