public class stringMatch {
    public static int strStr(String haystack, String needle) {

        int res = haystack.indexOf(needle);
        return res;

    }

    public static void main(String args[]) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
}
