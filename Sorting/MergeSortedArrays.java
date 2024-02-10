import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[4];
        int[] arr2 = new int[4];
        int[] arr3 = new int[8];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array 1 in sorted order:");
        for (int i = 0; i < 4; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.println("Enter array 2 in sorted order:");
        for (int i = 0; i < 4; i++) {
            arr2[i] = scanner.nextInt();
        }

        int ptr1 = 0, ptr2 = 0;
        for (int i = 0; i < 8; i++) {
            if (ptr1 < 4 && (ptr2 >= 4 || arr1[ptr1] < arr2[ptr2])) {
                arr3[i] = arr1[ptr1++];
            } else {
                arr3[i] = arr2[ptr2++];
            }
        }

        System.out.print("Output: ");
        for (int i = 0; i < 8; i++) {
            System.out.print(arr3[i] + " ");
        }
        scanner.close();
    }
}
