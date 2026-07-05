package JCF.Map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap {

    /*
     * =========================
     * HashMap (JCF) Study Notes
     * =========================
     *
     * What it is
     * - java.util.HashMap stores key-value pairs.
     * - Keys are unique; values may repeat.
     * - It does not maintain insertion order.
     * - It allows one null key and multiple null values.
     *
     * Key points
     * - Average O(1) for put, get, remove, containsKey.
     * - Not synchronized by default.
     * - Order is unspecified.
     *
     * Internal implementation
     * - Backed by an array of buckets.
     * - Each bucket holds nodes storing key, value, hash, and next reference.
     * - Collisions are handled by chaining.
     * - In modern Java, long chains can treeify into balanced trees.
     *
     * Default size, load factor, threshold, and growth
     * - Default initial capacity: 16.
     * - Default load factor: 0.75.
     * - Threshold formula: threshold = capacity * loadFactor.
     * - Default threshold: 16 * 0.75 = 12.
     * - Resize happens when size > threshold.
     * - On resize, capacity usually doubles.
     *
     * Hashing rule
     * - HashMap computes a hash for the key and maps it to a bucket index.
     * - Keys should implement proper equals() and hashCode().
     * - If hashCode/equals are inconsistent, lookup and replacement can fail.
     *
     * Common constructors
     * - HashMap() -> default capacity 16, load factor 0.75.
     * - HashMap(int initialCapacity)
     * - HashMap(int initialCapacity, float loadFactor)
     * - HashMap(Map<? extends K, ? extends V> m)
     *
     * Common methods
     *
     * Put / update
     * - put(K key, V value) -> inserts or updates key-value pair. Returns: previous
     * value or null.
     * - putIfAbsent(K key, V value) -> inserts only if key is absent. Returns:
     * previous value or null.
     * - putAll(Map<? extends K, ? extends V> m) -> copies all entries. Returns:
     * void.
     *
     * Get / check
     * - get(Object key) -> fetches value for key. Returns: value or null.
     * - getOrDefault(Object key, V defaultValue) -> fetches value or default.
     * Returns: value.
     * - containsKey(Object key) -> checks key existence. Returns: true/false.
     * - containsValue(Object value) -> checks value existence. Returns: true/false.
     *
     * Remove / clear
     * - remove(Object key) -> removes entry by key. Returns: removed value or null.
     * - remove(Object key, Object value) -> removes only if pair matches. Returns:
     * true/false.
     * - clear() -> removes all entries. Returns: void.
     *
     * Size / state
     * - size() -> number of entries. Returns: int.
     * - isEmpty() -> empty check. Returns: true/false.
     *
     * Views
     * - keySet() -> returns Set<K> view of keys.
     * - values() -> returns Collection<V> view of values.
     * - entrySet() -> returns Set<Map.Entry<K,V>> view of entries.
     *
     * Traversal / conversion
     * - keySet().iterator() -> iterate keys.
     * - entrySet().iterator() -> iterate key-value pairs.
     * - forEach(BiConsumer<? super K, ? super V>) -> traverses entries.
     *
     * Types you can reference it with
     * - HashMap<K, V> hm = new HashMap<>();
     * - Map<K, V> hm = new HashMap<>();
     *
     * HashMap vs LinkedHashMap vs TreeMap
     * - HashMap: no ordering, average O(1).
     * - LinkedHashMap: insertion/access order, average O(1).
     * - TreeMap: sorted keys, O(log n).
     *
     * When to use
     * - Use when you need fast key-based lookup and ordering does not matter.
     * - Great for counting, indexing, frequency maps, memoization.
     *
     * Complexity (average case)
     * - put: O(1)
     * - get: O(1)
     * - remove: O(1)
     * - containsKey: O(1)
     * - containsValue: O(n)
     */

    public static void main(String[] args) {
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        System.out.println("put(A, 1): previous -> " + map.put("A", 1));
        System.out.println("put(B, 2): previous -> " + map.put("B", 2));
        System.out.println("put(A, 3): previous -> " + map.put("A", 3));
        map.put(null, 99);

        System.out.println("Map: " + map);
        System.out.println("Size: " + map.size());
        System.out.println("Contains key A: " + map.containsKey("A"));
        System.out.println("Contains value 2: " + map.containsValue(2));
        System.out.println("Get A: " + map.get("A"));
        System.out.println("Get C with default: " + map.getOrDefault("C", -1));

        System.out.println("Remove B: " + map.remove("B"));
        System.out.println("After remove: " + map);

        System.out.println("Iterating over keys:");
        Iterator<String> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            System.out.println(keyIterator.next());
        }

        System.out.println("Iterating over entries:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        Set<String> keyView = map.keySet();
        Collection<Integer> valueView = map.values();
        System.out.println("As Set of keys size: " + keyView.size());
        System.out.println("As values collection size: " + valueView.size());

        map.clear();
        System.out.println("After clear, isEmpty: " + map.isEmpty());
    }
}
