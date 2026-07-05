package JCF.Set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class LinkedHashSet {

    /*
     * ===============================
     * LinkedHashSet (JCF) Study Notes
     * ===============================
     *
     * What it is
     * - java.util.LinkedHashSet is a hash table + linked list based Set.
     * - Stores unique elements only (no duplicates).
     * - Preserves insertion order during iteration.
     * - creating object from Set is valid.
     *
     * Key points
     * - No duplicate elements.
     * - Allows one null element.
     * - Maintains insertion-order iteration.
     * - Average O(1) for add/remove/contains.
     * - Not synchronized (not thread-safe by default).
     *
     * Internal implementation
     * - Built on top of LinkedHashMap internally.
     * - Elements are stored as keys in the map (dummy value for each key).
     * - In addition to hash buckets, nodes are connected by a doubly linked list.
     * - Linked list gives predictable insertion-order traversal.
     *
     * Default size, load factor, threshold, and growth
     * - Default initial capacity: 16.
     * - Default load factor: 0.75.
     * - Threshold formula: threshold = capacity * loadFactor.
     * - Default threshold: 16 * 0.75 = 12.
     * - Resize trigger: when size > threshold.
     * - On resize, capacity typically doubles.
     *
     * Common constructors
     * - LinkedHashSet() -> capacity 16, load factor 0.75.
     * - LinkedHashSet(Collection<? extends E> c)
     * - LinkedHashSet(int initialCapacity)
     * - LinkedHashSet(int initialCapacity, float loadFactor)
     *
     * Common methods
     *
     * Add / remove
     * - add(E e) -> adds element if absent. Returns: true if added.
     * - remove(Object o) -> removes element if present. Returns: true if removed.
     * - clear() -> removes all elements. Returns: void.
     *
     * Search / state
     * - contains(Object o) -> existence check. Returns: true/false.
     * - size() -> number of elements. Returns: int.
     * - isEmpty() -> empty check. Returns: true/false.
     *
     * Bulk operations
     * - addAll(Collection<? extends E> c) -> adds all elements. Returns: true if
     * set changed.
     * - removeAll(Collection<?> c) -> removes all matching elements. Returns: true
     * if set changed.
     * - retainAll(Collection<?> c) -> keeps only matching elements. Returns: true
     * if set changed.
     * - containsAll(Collection<?> c) -> checks subset relation. Returns:
     * true/false.
     *
     * Traversal / conversion
     * - iterator() -> insertion-order iterator.
     * - toArray() -> converts to Object[]. Returns: Object[].
     * - toArray(T[] a) -> converts to typed array. Returns: T[].
     *
     * Equality rules (important)
     * - For custom objects, equals() and hashCode() must be consistent.
     * - Wrong equals/hashCode can break uniqueness and lookup behavior.
     *
     * Types you can reference it with
     * - LinkedHashSet<E> lhs = new LinkedHashSet<>();
     * - Set<E> lhs = new LinkedHashSet<>();
     * - Collection<E> lhs = new LinkedHashSet<>();
     *
     * HashSet vs LinkedHashSet vs TreeSet
     * - HashSet: fastest average, no order guarantee.
     * - LinkedHashSet: insertion-order preserved, slightly more memory overhead.
     * - TreeSet: sorted order, O(log n) operations.
     *
     * When to use
     * - Use when you need uniqueness + predictable insertion-order traversal.
     * - Great for duplicate removal while preserving original order.
     *
     * Complexity (average case)
     * - add: O(1)
     * - remove: O(1)
     * - contains: O(1)
     * - Iteration: O(n)
     */

    public static void main(String[] args) {
        java.util.LinkedHashSet<Integer> set = new java.util.LinkedHashSet<>();

        System.out.println("Add 10: " + set.add(10));
        System.out.println("Add 20: " + set.add(20));
        System.out.println("Add 10 again: " + set.add(10));

        set.add(30);
        set.add(5);
        set.add(null);

        System.out.println("LinkedHashSet (insertion order): " + set);
        System.out.println("Contains 20: " + set.contains(20));
        System.out.println("Contains 99: " + set.contains(99));
        System.out.println("Size: " + set.size());

        System.out.println("Remove 20: " + set.remove(20));
        System.out.println("After remove: " + set);

        System.out.println("Iterating using Iterator (still insertion order):");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Object[] array = set.toArray();
        System.out.println("toArray length: " + array.length);

        Set<Integer> setView = set;
        Collection<Integer> collectionView = set;
        System.out.println("As Set size: " + setView.size());
        System.out.println("As Collection empty: " + collectionView.isEmpty());

        set.clear();
        System.out.println("After clear, isEmpty: " + set.isEmpty());
    }
}
