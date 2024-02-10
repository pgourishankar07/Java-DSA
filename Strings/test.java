
public class test {
    public static int digits(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    public static void main(String args[]) {
        String s1 = "Hello"; // String literal
        String s2 = "Hello"; // String literal
        String s3 = s1; // same reference

        // Changing the value of s1
        s1 = "Java";

        // Updating with concat() operation
        s2.concat(" World");

        // The concatenated String will be created as a new instance and an object
        // should refer to that instance to get the concatenated value.
        String newS3 = s3.concat(" Scaler");

        System.out.println("s1 refers to " + s1);
        System.out.println("s2 refers to " + s2);
        System.out.println("s3 refers to " + s3);
        System.out.println("newS3 refers to " + newS3);

        System.out.println(digits(12));

    }

    class Solution {
        public boolean isPalindrome(String s) {

            String res = s.replaceAll("[^a-zA-Z0-9]", "");
            res = res.toLowerCase();
            int n = res.length();

            for (int i = 0; i < n / 2; i++) {
                if (res.charAt(i) != (res.charAt(n - i - 1))) {
                    return false;
                }
            }

            return true;

        }
    }

    class Solution2 {
        public int compress(char[] chars) {

            int n = chars.length;

            int res = 0;

            for (int i = 0; i < n - 1; i++) {

                int j = i + 1;
                int count = 1;

                while (j < n && chars[i] == chars[j]) {
                    count++;
                    j++;
                }

                // i = j-1;

                i++;
                res = i;
                chars[i] = Integer.toString(count).charAt(0);
                // System.out.println(chars[i]+" "+count);

            }

            return res + 1;

        }
    }
}
