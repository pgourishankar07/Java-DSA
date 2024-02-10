//Leetcode:19_removeNthFromEnd

import java.util.*;

public class _4_impQ1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("The LL is : " + list);

        System.out.print("Enter nth Node to delete form the last : ");
        int n;
        n = sc.nextInt();

        int num = list.size() - n;

        System.out.println("The Nth Node is : " + list.get(num));

        list.remove(num);
        System.out.println("After Deletion the LL is : " + list);

        sc.close();
    }
}
