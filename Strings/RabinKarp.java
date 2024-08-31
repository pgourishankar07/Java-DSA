public class RabinKarp {

    // Prime number used for hashing
    private final static int PRIME = 2;

    // Rabin-Karp algorithm to find a pattern in a text
    public static int rabinKarpSearch(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        long patternHash = createHash(pattern, m);
        long textHash = createHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            // If hash values match, check the characters
            if (patternHash == textHash && checkEqual(text, i, i + m - 1, pattern, 0, m - 1)) {
                return i; // Pattern found at index i
            }
            // Calculate hash value for the next substring
            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, m);
            }
        }
        return -1; // Pattern not found
    }

    // Create initial hash value for the pattern or first substring of text
    private static long createHash(String str, int end) {
        long hash = 0;
        for (int i = 0; i < end; i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    // Recalculate hash value by removing the left character and adding the next
    // character
    private static long recalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patternLen) {
        long newHash = oldHash - str.charAt(oldIndex);
        newHash = newHash / PRIME;
        newHash += str.charAt(newIndex) * Math.pow(PRIME, patternLen - 1);
        return newHash;
    }

    // Check if the two substrings are actually equal when their hash values match
    private static boolean checkEqual(String str1, int start1, int end1, String str2, int start2, int end2) {
        if (end1 - start1 != end2 - start2) {
            return false;
        }
        while (start1 <= end1 && start2 <= end2) {
            if (str1.charAt(start1) != str2.charAt(start2)) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    // Main function to test the Rabin-Karp algorithm
    public static void main(String[] args) {
        String text = "Hello, welcome to Java programming!";
        String pattern = "Java";
        int index = rabinKarpSearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found");
        }

    }
}
