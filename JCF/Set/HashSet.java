package JCF.Set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class HashSet {

    /*
     * =========================
     * HashSet (JCF) Study Notes
     * =========================
     *
     * What it is
     * - java.util.HashSet is a hash table based implementation of Set.
     * - Stores unique elements only (no duplicates).
     * - Backed internally by a HashMap (elements are map keys).
     * - creating object from Set is valid
     *
     * Key points
     * - No insertion-order guarantee.
     * - Allows one null element.
     * - Average O(1) for add, remove, contains.
     * - Not synchronized (not thread-safe by default).
     *
     * Internal implementation
     * - HashSet uses a HashMap<E, Object> internally.
     * - Each set element is stored as a key in the map.
     * - A dummy constant object is used as the map value.
     * - Bucket collisions use linked nodes and may treeify for large collisions.
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
     * - HashSet() -> capacity 16, load factor 0.75.
     * - HashSet(Collection<? extends E> c)
     * - HashSet(int initialCapacity)
     * - HashSet(int initialCapacity, float loadFactor)
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
     * - iterator() -> Iterator<E> over set.
     * - toArray() -> converts to Object[]. Returns: Object[].
     * - toArray(T[] a) -> converts to typed array. Returns: T[].
     *
     * Equality rules (important)
     * - For custom objects, equals() and hashCode() must be consistent.
     * - If equals/hashCode are wrong, duplicates and lookup behavior can break.
     *
     * Types you can reference it with
     * - HashSet<E> hs = new HashSet<>();
     * - Set<E> hs = new HashSet<>();
     * - Collection<E> hs = new HashSet<>();
     *
     * HashSet vs LinkedHashSet vs TreeSet
     * - HashSet: fastest average operations, no order guarantee.
     * - LinkedHashSet: insertion-order preserved, slightly more memory/time
     * overhead.
     * - TreeSet: sorted order, O(log n) operations.
     *
     * When to use
     * - Use when uniqueness matters and ordering does not matter.
     * - Great for membership checks, duplicate removal, visited sets in graph
     * problems.
     *
     * Complexity (average case)
     * - add: O(1)
     * - remove: O(1)
     * - contains: O(1)
     * - Iteration: O(n)
     */

    public static void main(String[] args) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        System.out.println("Add 10: " + set.add(10));
        System.out.println("Add 20: " + set.add(20));
        System.out.println("Add 10 again: " + set.add(10));

        set.add(30);
        set.add(null);

        System.out.println("Set: " + set);
        System.out.println("Contains 20: " + set.contains(20));
        System.out.println("Contains 99: " + set.contains(99));
        System.out.println("Size: " + set.size());

        System.out.println("Remove 20: " + set.remove(20));
        System.out.println("After remove: " + set);

        System.out.println("Iterating using Iterator:");
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
