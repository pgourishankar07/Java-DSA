package JCF.Map;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTable {

    /*
     * =========================
     * Hashtable (JCF) Study Notes
     * =========================
     *
     * What it is
     * - java.util.Hashtable is an older key-value map implementation in JCF.
     * - Stores key-value pairs with unique keys.
     * - It is synchronized, so individual operations are thread-safe.
     * - It is a legacy class; HashMap is usually preferred in modern code.
     *
     * Key points
     * - Keys and values cannot be null.
     * - No insertion-order guarantee.
     * - Synchronized methods make it slower than HashMap in single-threaded use.
     * - Average O(1) for put/get/remove.
     *
     * Internal implementation
     * - Uses an array of buckets.
     * - Each bucket holds nodes with key, value, hash, and next reference.
     * - Collisions are handled by chaining.
     * - Modern Tree-bin style treeification is not something to rely on for
     * Hashtable notes; it is historically chain-based.
     *
     * Default size, load factor, threshold, and growth
     * - Default initial capacity: 11.
     * - Default load factor: 0.75.
     * - Threshold formula: threshold = capacity * loadFactor.
     * - Default threshold: 11 * 0.75 = 8 (integer-based effective threshold
     * behavior).
     * - Resize happens when size exceeds threshold.
     * - On resize, capacity grows according to Hashtable's internal rehash
     * behavior.
     *
     * Hashing rule
     * - Key hash is used to select a bucket.
     * - Keys should implement proper equals() and hashCode().
     * - Bad equals/hashCode breaks lookup and update behavior.
     *
     * Common constructors
     * - Hashtable() -> default capacity 11, load factor 0.75.
     * - Hashtable(int initialCapacity)
     * - Hashtable(int initialCapacity, float loadFactor)
     * - Hashtable(Map<? extends K, ? extends V> t)
     *
     * Common methods
     *
     * Put / update
     * - put(K key, V value) -> inserts or updates key-value pair. Returns: previous
     * value or null.
     * - putIfAbsent(K key, V value) -> inserts only if absent. Returns: previous
     * value or null.
     * - putAll(Map<? extends K, ? extends V> t) -> copies all entries. Returns:
     * void.
     *
     * Get / check
     * - get(Object key) -> fetches value for key. Returns: value or null.
     * - containsKey(Object key) -> checks key existence. Returns: true/false.
     * - contains(Object value) -> legacy value check. Returns: true/false.
     * - containsValue(Object value) -> checks value existence. Returns: true/false.
     *
     * Remove / clear
     * - remove(Object key) -> removes entry by key. Returns: removed value or null.
     * - clear() -> removes all entries. Returns: void.
     *
     * Size / state
     * - size() -> number of entries. Returns: int.
     * - isEmpty() -> empty check. Returns: true/false.
     *
     * Views
     * - keys() -> Enumeration<K> of keys.
     * - elements() -> Enumeration<V> of values.
     * - keySet() -> Set<K> view of keys.
     * - values() -> Collection<V> view of values.
     * - entrySet() -> Set<Map.Entry<K,V>> view of entries.
     *
     * Traversal / conversion
     * - keys() and elements() are legacy Enumeration-based traversal.
     * - keySet().iterator() and entrySet().iterator() also work.
     * - forEach(BiConsumer<? super K, ? super V>) -> traverses entries.
     *
     * Types you can reference it with
     * - Hashtable<K, V> ht = new Hashtable<>();
     * - Map<K, V> ht = new Hashtable<>();
     *
     * Hashtable vs HashMap vs LinkedHashMap
     * - Hashtable: synchronized, legacy, no nulls.
     * - HashMap: not synchronized, allows one null key.
     * - LinkedHashMap: predictable order, not synchronized.
     *
     * When to use
     * - Use mainly for legacy code or when you specifically need synchronized map
     * behavior.
     * - In modern code, prefer ConcurrentHashMap for concurrency or HashMap +
     * external synchronization.
     *
     * Complexity (average case)
     * - put: O(1)
     * - get: O(1)
     * - remove: O(1)
     * - containsKey: O(1)
     * - containsValue: O(n)
     */

    public static void main(String[] args) {
        java.util.Hashtable<String, Integer> table = new java.util.Hashtable<>();

        System.out.println("put(A, 1): previous -> " + table.put("A", 1));
        System.out.println("put(B, 2): previous -> " + table.put("B", 2));
        System.out.println("put(A, 3): previous -> " + table.put("A", 3));

        System.out.println("Hashtable: " + table);
        System.out.println("Size: " + table.size());
        System.out.println("Contains key A: " + table.containsKey("A"));
        System.out.println("Contains value 2: " + table.containsValue(2));
        System.out.println("Get A: " + table.get("A"));
        System.out.println("Get C: " + table.get("C"));

        System.out.println("Remove B: " + table.remove("B"));
        System.out.println("After remove: " + table);

        System.out.println("Iterating using Enumeration of keys:");
        Enumeration<String> keyEnum = table.keys();
        while (keyEnum.hasMoreElements()) {
            System.out.println(keyEnum.nextElement());
        }

        System.out.println("Iterating using Enumeration of values:");
        Enumeration<Integer> valueEnum = table.elements();
        while (valueEnum.hasMoreElements()) {
            System.out.println(valueEnum.nextElement());
        }

        System.out.println("Iterating using Iterator on keySet:");
        Iterator<String> iterator = table.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<String> keyView = table.keySet();
        Collection<Integer> valueView = table.values();
        System.out.println("As Set of keys size: " + keyView.size());
        System.out.println("As values collection size: " + valueView.size());

        table.clear();
        System.out.println("After clear, isEmpty: " + table.isEmpty());
    }
}
