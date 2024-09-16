public class MaxXor {
    class Solution {

        public TrieNode root = new TrieNode();

        class TrieNode {
            TrieNode zero, one;

            public TrieNode() {
                zero = null;
                one = null;
            }
        }

        // inserting binary representation of the num from 000....101 (32-bit) for 5
        public void insert(int num) {
            TrieNode curr = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0) {
                    if (curr.zero == null) {
                        curr.zero = new TrieNode();
                    }
                    curr = curr.zero;
                } else {
                    if (curr.one == null) {
                        curr.one = new TrieNode();
                    }
                    curr = curr.one;
                }
            }
        }

        // searching opposite bits for the given num to get maxXor for that num
        public int search(int num) {
            TrieNode curr = root;
            int maxXor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0) {
                    if (curr.one != null) {
                        curr = curr.one;
                        maxXor += (1 << i);
                    } else {
                        curr = curr.zero;
                    }
                } else {
                    if (curr.zero != null) {
                        curr = curr.zero;
                        maxXor += (1 << i);
                    } else {
                        curr = curr.one;
                    }
                }
            }

            return maxXor;
        }

        public int findMaximumXOR(int[] nums) {
            int maxXor = Integer.MIN_VALUE;

            for (int num : nums) {
                insert(num);
            }

            for (int num : nums) {
                maxXor = Math.max(maxXor, search(num));
            }

            return maxXor;
        }
    }

    /*
     * https://www.youtube.com/watch?v=jCuZCbXnpLo&ab_channel=Techdose
     */
}
