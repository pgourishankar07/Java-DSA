package JCF.Set.SortedSet;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public class TreeSet {

    /*
     * =========================
     * TreeSet (JCF) Study Notes
     * =========================
     *
     * What it is
     * - java.util.TreeSet is a sorted Set implementation.
     * - Stores unique elements only (no duplicates).
     * - Elements are maintained in sorted order.
     * - creating object from Set, SortedSet, NavigableSet is valid
     *
     * Key points
     * - No duplicates.
     * - Natural ordering by default (Comparable).
     * - Custom ordering via Comparator.
     * - Null is not allowed in normal natural-order TreeSet.
     * - Not synchronized.
     *
     * Internal implementation
     * - Backed by a TreeMap internally.
     * - Uses a self-balancing Red-Black Tree.
     * - Set elements are stored as map keys with dummy values.
     *
     * Ordering rules
     * - Default: ascending order using compareTo().
     * - Custom: pass Comparator in constructor.
     * - Equality in TreeSet is based on compareTo/Comparator result being 0.
     * - If compareTo says two objects are equal, second one is treated as
     * duplicate.
     *
     * Common constructors
     * - TreeSet() -> natural-order sorted set.
     * - TreeSet(Comparator<? super E> comparator)
     * - TreeSet(Collection<? extends E> c)
     * - TreeSet(SortedSet<E> s)
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
     * Boundary methods
     * - first() -> smallest element. Returns: element.
     * - last() -> largest element. Returns: element.
     *
     * Navigational methods (NavigableSet)
     * - lower(E e) -> greatest element < e. Returns: element or null.
     * - floor(E e) -> greatest element <= e. Returns: element or null.
     * - ceiling(E e) -> smallest element >= e. Returns: element or null.
     * - higher(E e) -> smallest element > e. Returns: element or null.
     * - pollFirst() -> removes and returns smallest. Returns: element or null.
     * - pollLast() -> removes and returns largest. Returns: element or null.
     *
     * Range views
     * - headSet(toElement) -> view of elements < toElement.
     * - tailSet(fromElement) -> view of elements >= fromElement.
     * - subSet(fromElement, toElement) -> view in [from, to) range.
     * - descendingSet() -> reverse-order view.
     *
     * Bulk operations
     * - addAll(Collection<? extends E> c) -> adds all. Returns: true if changed.
     * - removeAll(Collection<?> c) -> removes all matching. Returns: true if
     * changed.
     * - retainAll(Collection<?> c) -> keeps only matching. Returns: true if
     * changed.
     * - containsAll(Collection<?> c) -> subset check. Returns: true/false.
     *
     * Traversal / conversion
     * - iterator() -> ascending-order iterator.
     * - descendingIterator() -> descending-order iterator.
     * - toArray() -> converts to Object[]. Returns: Object[].
     * - toArray(T[] a) -> converts to typed array. Returns: T[].
     *
     * Types you can reference it with
     * - TreeSet<E> ts = new TreeSet<>();
     * - Set<E> ts = new TreeSet<>();
     * - SortedSet<E> ts = new TreeSet<>();
     * - NavigableSet<E> ts = new TreeSet<>();
     * - Collection<E> ts = new TreeSet<>();
     * 
     * SortedSet vs NavigableSet
     * - SortedSet<E> ts = new TreeSet<>();
     * Use this when you only need sorted order plus the basic sorted-set API.
     * Available methods are mainly first(), last(), headSet(), tailSet(), subSet(),
     * add(), remove(), contains(), and iteration.
     * - NavigableSet<E> ts = new TreeSet<>();
     * Use this when you need richer navigation around elements in sorted order.
     * It adds lower(), floor(), ceiling(), higher(), pollFirst(), pollLast(),
     * descendingSet(), descendingIterator(), and inclusive range-view overloads.
     *
     * When to use what
     * - Use SortedSet when your code only needs the simpler sorted-set contract and
     * you want a narrower, cleaner API.
     * - Use NavigableSet when you need nearest-element lookups, reverse traversal,
     * polling from ends, or precise range queries.
     * - In practice, if you are using TreeSet directly in modern code, NavigableSet
     * is usually the more useful reference type.
     * - If you want the broadest general contract, use Set<E>; if you want sorted
     * behavior, prefer SortedSet<E> or NavigableSet<E>.
     *
     * HashSet vs LinkedHashSet vs TreeSet
     * - HashSet: no order, average O(1).
     * - LinkedHashSet: insertion order, average O(1).
     * - TreeSet: sorted order, O(log n) operations.
     *
     * When to use
     * - Use when you need uniqueness + automatic sorted order.
     * - Great for floor/ceiling/range-query type problems.
     *
     * Complexity (typical)
     * - add: O(log n)
     * - remove: O(log n)
     * - contains: O(log n)
     * - first/last/lower/floor/ceiling/higher: O(log n)
     * - Iteration: O(n)
     */

    public static void main(String[] args) {
        java.util.TreeSet<Integer> set = new java.util.TreeSet<>();

        System.out.println("Add 40: " + set.add(40));
        System.out.println("Add 10: " + set.add(10));
        System.out.println("Add 30: " + set.add(30));
        System.out.println("Add 20: " + set.add(20));
        System.out.println("Add 20 again: " + set.add(20));

        System.out.println("TreeSet (sorted): " + set);
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());
        System.out.println("Lower(25): " + set.lower(25));
        System.out.println("Floor(30): " + set.floor(30));
        System.out.println("Ceiling(25): " + set.ceiling(25));
        System.out.println("Higher(30): " + set.higher(30));

        System.out.println("headSet(30): " + set.headSet(30));
        System.out.println("tailSet(20): " + set.tailSet(20));
        System.out.println("subSet(20, 40): " + set.subSet(20, 40));

        System.out.println("Poll first: " + set.pollFirst());
        System.out.println("Poll last: " + set.pollLast());
        System.out.println("After polls: " + set);

        System.out.println("Iterator (ascending):");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Iterator (descending):");
        Iterator<Integer> descending = set.descendingIterator();
        while (descending.hasNext()) {
            System.out.println(descending.next());
        }

        java.util.TreeSet<Integer> maxStyle = new java.util.TreeSet<>(Comparator.reverseOrder());
        maxStyle.add(1);
        maxStyle.add(4);
        maxStyle.add(2);
        System.out.println("Custom comparator TreeSet: " + maxStyle);

        Set<Integer> setView = set;
        SortedSet<Integer> sortedView = set;
        NavigableSet<Integer> navView = set;
        Collection<Integer> collectionView = set;

        System.out.println("As Set size: " + setView.size());
        System.out.println("As SortedSet first: " + sortedView.first());
        System.out.println("As NavigableSet ceiling(25): " + navView.ceiling(25));
        System.out.println("As Collection empty: " + collectionView.isEmpty());
    }
}
