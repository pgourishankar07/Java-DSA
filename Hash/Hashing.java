import java.util.ArrayList;
import java.util.LinkedList;

public class Hashing {

    static class HashMapp<K, V> {

        int n; // nodes
        int N; // buckets

        class Node {
            K key;
            V val;

            Node(K key, V val) {
                this.key = key;
                this.val = val;
            }

        }

        LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")

        HashMapp() {
            this.N = 4;
            this.buckets = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // ____________________________________

        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        private int srchinLL(K key, int bi) {

            LinkedList<Node> ll = buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }

            return -1;

        }

        @SuppressWarnings("unchecked")

        private void rehash() {
            N = N * 2;
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.val);
                }
            }
        }

        // put____________
        public void put(K key, V val) {

            int bi = hashFunction(key); // bucket index
            int di = srchinLL(key, bi); // data index

            if (di == -1) {
                buckets[bi].add(new Node(key, val));
                n++;
            } else {
                Node node = buckets[bi].get(di);
                node.val = val;
            }

            double lambda = (double) n / N; // threshold value

            if (lambda > 2.0) { // the lesser the num more fast performance
                rehash();
            }

        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = srchinLL(key, bi);

            if (di == -1) {
                return null;
            } else {
                Node node = buckets[bi].get(di);
                return node.val;
            }
        }

        public boolean contains(K key) {
            int bi = hashFunction(key);
            int di = srchinLL(key, bi);

            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = srchinLL(key, bi);

            if (di == -1) {
                return null;
            } else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.val;
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String args[]) {
        HashMapp<String, Integer> map = new HashMapp<>();
        map.put("USA", 1);
        map.put("India", 2);
        map.put("China", 3);
        map.put("Africa", 4);

        System.out.println(map.get("USA"));

        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }

    }
}
