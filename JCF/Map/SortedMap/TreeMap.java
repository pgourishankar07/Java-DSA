package JCF.Map.SortedMap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;

public class TreeMap {

    /*
     * ========================
     * TreeMap (JCF) Study Notes
     * ========================
     *
     * What it is
     * - java.util.TreeMap stores key-value pairs in sorted key order.
     * - Keys are unique; values may repeat.
     * - It is a sorted map and also a navigable map.
     * - create obj from Map, SortedMap, NavigableMap is valid
     *
     * Key points
     * - Keys are ordered by natural order or Comparator.
     * - Does not allow null keys in natural-order TreeMap.
     * - Null values are allowed.
     * - Not synchronized.
     * - Average operations are O(log n).
     *
     * Internal implementation
     * - Backed by a Red-Black Tree.
     * - Each node stores key, value, left, right, parent, and color.
     * - Balanced tree keeps search and update logarithmic.
     *
     * Ordering rules
     * - Default: ascending order by key using compareTo().
     * - Custom ordering: pass Comparator in constructor.
     * - If comparator/compareTo returns 0, the key is treated as duplicate.
     *
     * Common constructors
     * - TreeMap() -> natural-order map.
     * - TreeMap(Comparator<? super K> comparator)
     * - TreeMap(Map<? extends K, ? extends V> m)
     * - TreeMap(SortedMap<K, ? extends V> m)
     *
     * Common methods
     *
     * Put / update
     * - put(K key, V value) -> inserts or updates entry. Returns: previous value or
     * null.
     * - putIfAbsent(K key, V value) -> inserts only if missing. Returns: previous
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
     * - remove(Object key) -> removes by key. Returns: removed value or null.
     * - remove(Object key, Object value) -> removes only if pair matches. Returns:
     * true/false.
     * - clear() -> removes all entries. Returns: void.
     *
     * Boundary / navigational methods
     * - firstKey() -> smallest key. Returns: key.
     * - lastKey() -> largest key. Returns: key.
     * - lowerKey(K key) -> greatest key < given key. Returns: key or null.
     * - floorKey(K key) -> greatest key <= given key. Returns: key or null.
     * - ceilingKey(K key) -> smallest key >= given key. Returns: key or null.
     * - higherKey(K key) -> smallest key > given key. Returns: key or null.
     * - pollFirstEntry() -> removes and returns smallest entry. Returns:
     * Map.Entry<K,V> or null.
     * - pollLastEntry() -> removes and returns largest entry. Returns:
     * Map.Entry<K,V> or null.
     *
     * Range views
     * - headMap(toKey) -> keys less than toKey.
     * - tailMap(fromKey) -> keys greater than or equal to fromKey.
     * - subMap(fromKey, toKey) -> keys in [from, to) range.
     * - descendingMap() -> reverse-order view.
     *
     * Views
     * - keySet() -> Set<K> view of keys in sorted order.
     * - values() -> Collection<V> view of values in key order.
     * - entrySet() -> Set<Map.Entry<K,V>> view of entries in key order.
     *
     * Traversal / conversion
     * - keySet().iterator() -> iterate keys in sorted order.
     * - entrySet().iterator() -> iterate key-value pairs in sorted order.
     * - forEach(BiConsumer<? super K, ? super V>) -> traverses entries.
     *
     * Types you can reference it with
     * - TreeMap<K, V> tm = new TreeMap<>();
     * - Map<K, V> tm = new TreeMap<>();
     * - SortedMap<K, V> tm = new TreeMap<>();
     * - NavigableMap<K, V> tm = new TreeMap<>();
     *
     * HashMap vs LinkedHashMap vs TreeMap
     * - HashMap: no order, average O(1).
     * - LinkedHashMap: insertion/access order, average O(1).
     * - TreeMap: sorted keys, O(log n).
     *
     * When to use
     * - Use when you need key-value data plus automatic sorted key order.
     * - Great for range queries, floor/ceiling lookups, and ordered iteration.
     *
     * Complexity (typical)
     * - put: O(log n)
     * - get: O(log n)
     * - remove: O(log n)
     * - containsKey: O(log n)
     * - containsValue: O(n)
     */

    public static void main(String[] args) {
        java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();

        System.out.println("put(40, D): previous -> " + map.put(40, "D"));
        System.out.println("put(10, A): previous -> " + map.put(10, "A"));
        System.out.println("put(30, C): previous -> " + map.put(30, "C"));
        System.out.println("put(20, B): previous -> " + map.put(20, "B"));
        System.out.println("put(20, BB): previous -> " + map.put(20, "BB"));

        System.out.println("TreeMap (sorted by key): " + map);
        System.out.println("Size: " + map.size());
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());
        System.out.println("LowerKey(25): " + map.lowerKey(25));
        System.out.println("FloorKey(30): " + map.floorKey(30));
        System.out.println("CeilingKey(25): " + map.ceilingKey(25));
        System.out.println("HigherKey(30): " + map.higherKey(30));

        System.out.println("headMap(30): " + map.headMap(30));
        System.out.println("tailMap(20): " + map.tailMap(20));
        System.out.println("subMap(20, 40): " + map.subMap(20, 40));
        System.out.println("descendingMap: " + map.descendingMap());

        System.out.println("Get 20: " + map.get(20));
        System.out.println("Get 99 with default: " + map.getOrDefault(99, "NA"));
        System.out.println("Contains key 30: " + map.containsKey(30));
        System.out.println("Contains value C: " + map.containsValue("C"));

        System.out.println("Remove 30: " + map.remove(30));
        System.out.println("After remove: " + map);

        System.out.println("Iterating over keys:");
        Iterator<Integer> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            System.out.println(keyIterator.next());
        }

        System.out.println("Iterating over entries:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        Set<Integer> keyView = map.keySet();
        Collection<String> valueView = map.values();
        SortedMap<Integer, String> sortedView = map;
        NavigableMap<Integer, String> navView = map;
        System.out.println("As Set size: " + keyView.size());
        System.out.println("As values collection size: " + valueView.size());
        System.out.println("As SortedMap firstKey: " + sortedView.firstKey());
        System.out.println("As NavigableMap ceilingKey(25): " + navView.ceilingKey(25));

        java.util.TreeMap<Integer, String> reverseMap = new java.util.TreeMap<>(Comparator.reverseOrder());
        reverseMap.put(1, "one");
        reverseMap.put(3, "three");
        reverseMap.put(2, "two");
        System.out.println("Custom comparator TreeMap: " + reverseMap);

        map.clear();
        System.out.println("After clear, isEmpty: " + map.isEmpty());
    }
}
