import java.util.ArrayList;

class test {

    // public int[] plusOne(int[] digits) {

    // for (int i = digits.length - 1; i >= 0; i--) {
    // if (digits[i] < 9) {
    // digits[i]++;
    // return digits;
    // }
    // digits[i] = 0;
    // }

    // digits = new int[digits.length + 1];
    // digits[0] = 1;
    // return digits;
    // }

    static class HashMappp<K, V> {
        int n;// nodes
        int N;// bucket size

        class Node {
            K key;
            V value;

            Node(K k, V v) {
                key = k;
                value = v;
            }
        }

        ArrayList<Node> bucket[];

        @SuppressWarnings("unchecked")
        HashMappp() {
            this.N = 4;
            this.bucket = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                bucket[i] = new ArrayList<>();
            }
        }

        int hash(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        int searchLL(K key, int bi) {
            int idx = 0;
            for (Node i : bucket[bi]) {
                if (i.key == key) {
                    return idx;
                }
                idx++;
            }
            return -1;
        }

        void put(K key, V value) {

            int bi = hash(key);
            int found = searchLL(key, bi);
            if (found == -1) {
                Node node = new Node(key, value);
                bucket[bi].add(node);
                n++;
            } else {
                Node node = bucket[bi].get(found);
                node.value = value;
            }
        }

        V get(K key) {
            int bi = hash(key);
            int found = searchLL(key, bi);
            if (found == -1) {
                return null;
            } else {
                return bucket[bi].get(found).value;
            }
        }

    }

    public static void main(String[] args) {
        HashMappp<Integer, Integer> mapp = new HashMappp();
        mapp.put(1, 10);

        System.out.println(mapp.get(1));
    }
}