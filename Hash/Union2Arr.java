import java.util.HashSet;

class Union2Arr {
    public static void intersection(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n1; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < n2; i++) {
            set.add(nums2[i]);
        }

        System.out.println(set);

    }

    public static void main(String args[]) {
        int[] arr1 = { 7, 3, 9 };
        int[] arr2 = { 6, 3, 9, 2, 4 };
        intersection(arr1, arr2);
    }

}