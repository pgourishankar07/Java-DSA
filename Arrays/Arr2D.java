import java.util.Scanner;

public class Arr2D {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Rows : ");
        int row = sc.nextInt();
        System.out.print("Enter Number of Column : ");
        int col = sc.nextInt();

        int[][] arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("Transpose Matrix :");
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}