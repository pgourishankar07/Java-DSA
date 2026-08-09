package JCF.Map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap {

    /*
     * ==============================
     * LinkedHashMap (JCF) Study Notes
     * ==============================
     *
     * What it is
     * - java.util.LinkedHashMap stores key-value pairs.
     * - Keys are unique; values may repeat.
     * - It preserves insertion order by default.
     * - Can also preserve access order if constructed that way.
     * - not thread safe, (Collections.synchronizedMap(new LinkedHashMap()))
     *
     * Key points
     * - No duplicate keys.
     * - Allows one null key and multiple null values.
     * - Maintains predictable iteration order.
     * - Average O(1) for put/get/remove.
     * - Not synchronized by default.
     *
     * Internal implementation
     * - Extends HashMap and adds a doubly linked list across entries.
     * - Each node stores key, value, hash, next, before, and after links.
     * - Hash table gives fast lookup; linked list gives stable order.
     *
     * Default size, load factor, threshold, and growth
     * - Default initial capacity: 16.
     * - Default load factor: 0.75.
     * - Threshold formula: threshold = capacity * loadFactor.
     * - Default threshold: 16 * 0.75 = 12.
     * - Resize happens when size > threshold.
     * - On resize, capacity usually doubles.
     *
     * Ordering modes
     * - Insertion order: default LinkedHashMap behavior.
     * - Access order: entries move to the end when accessed, useful for LRU caches.
     * - Access order is enabled by constructor with boolean accessOrder.
     *
     * Common constructors
     * - LinkedHashMap() -> default capacity 16, load factor 0.75, insertion order.
     * - LinkedHashMap(int initialCapacity)
     * - LinkedHashMap(int initialCapacity, float loadFactor)
     * - LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
     * - LinkedHashMap(Map<? extends K, ? extends V> m)
     *
     * Common methods
     *
     * Put / update
     * - put(K key, V value) -> inserts or updates key-value pair. Returns: previous
     * value or null.
     * - putIfAbsent(K key, V value) -> inserts only if absent. Returns: previous
     * value or null.
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
     * - keySet() -> Set<K> view of keys in iteration order.
     * - values() -> Collection<V> view of values in iteration order.
     * - entrySet() -> Set<Map.Entry<K,V>> view of entries in iteration order.
     *
     * Traversal / conversion
     * - keySet().iterator() -> iterate keys in predictable order.
     * - entrySet().iterator() -> iterate key-value pairs in predictable order.
     * - forEach(BiConsumer<? super K, ? super V>) -> traverses entries.
     *
     * Types you can reference it with
     * - LinkedHashMap<K, V> lm = new LinkedHashMap<>();
     * - Map<K, V> lm = new LinkedHashMap<>();
     *
     * HashMap vs LinkedHashMap vs TreeMap
     * - HashMap: no ordering, average O(1).
     * - LinkedHashMap: insertion/access order, average O(1).
     * - TreeMap: sorted keys, O(log n).
     *
     * When to use
     * - Use when you need key-value lookup plus predictable iteration order.
     * - Great for caches, ordered dictionaries, and stable JSON-like output.
     *
     * Complexity (average case)
     * - put: O(1)
     * - get: O(1)
     * - remove: O(1)
     * - containsKey: O(1)
     * - containsValue: O(n)
     */

    public static void main(String[] args) {
        java.util.LinkedHashMap<String, Integer> map = new java.util.LinkedHashMap<>();

        System.out.println("put(A, 1): previous -> " + map.put("A", 1));
        System.out.println("put(B, 2): previous -> " + map.put("B", 2));
        System.out.println("put(A, 3): previous -> " + map.put("A", 3));
        map.put(null, 99);

        System.out.println("LinkedHashMap (insertion order): " + map);
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

        java.util.LinkedHashMap<String, Integer> accessOrderMap = new java.util.LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("one", 1);
        accessOrderMap.put("two", 2);
        accessOrderMap.put("three", 3);
        accessOrderMap.get("one");
        System.out.println("Access-order map after get(one): " + accessOrderMap);

        map.clear();
        System.out.println("After clear, isEmpty: " + map.isEmpty());
    }
}
