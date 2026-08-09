package JCF.List;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Vector {

    /*
     * =========================
     * Vector (JCF) Study Notes
     * =========================
     *
     * What it is
     * - java.util.Vector is a resizable array class in JCF.
     * - It implements List and is synchronized (thread-safe for single method
     * calls).
     * - It is a legacy class; ArrayList is usually preferred in modern code.
     * - creating object from List is valid
     *
     * Key points
     * - Maintains insertion order
     * - Allows duplicate values
     * - Allows null values + maintains insertion order
     * - Fast random access by index: O(1)
     * - Add/remove at end: amortized O(1)
     * - Insert/remove in middle/front: O(n)
     *
     * Default size and growth
     * - Default initial capacity: 10.
     * - Constructor can set capacity and capacityIncrement.
     * - If capacityIncrement is 0 (default), capacity usually doubles when full.
     * - If capacityIncrement > 0, capacity grows by that fixed increment.
     * - Growth trigger: size + 1 > current capacity.
     *
     * Internal implementation
     * - elementData: Object[] backing array
     * - elementCount: number of stored elements
     * - capacityIncrement: custom growth step (if provided)
     * - Most public methods are synchronized.
     *
     * Common constructors
     * - Vector() -> default capacity 10.
     * - Vector(int initialCapacity)
     * - Vector(int initialCapacity, int capacityIncrement)
     * - Vector(Collection<? extends E> c)
     *
     * Common methods
     *
     * Add / insert
     * - add(E e) -> adds element at end. Returns: true.
     * - add(int index, E element) -> inserts at index. Returns: void.
     * - addElement(E obj) -> legacy add at end. Returns: void.
     * - addAll(Collection<? extends E> c) -> appends all. Returns: true if changed.
     * - addAll(int index, Collection<? extends E> c) -> inserts all at index.
     * Returns: true if changed.
     *
     * Get / set
     * - get(int index) -> fetches by index. Returns: element.
     * - set(int index, E element) -> replaces element. Returns: old element.
     * - elementAt(int index) -> legacy get. Returns: element.
     * - firstElement() -> first item. Returns: element.
     * - lastElement() -> last item. Returns: element.
     *
     * Remove
     * - remove(int index) -> removes by index. Returns: removed element.
     * - remove(Object o) -> removes first match. Returns: true if removed.
     * - removeElement(Object obj) -> legacy remove by value. Returns: true if
     * removed.
     * - removeAllElements() -> legacy clear. Returns: void.
     * - clear() -> removes all elements. Returns: void.
     *
     * Search
     * - contains(Object o) -> checks existence. Returns: true/false.
     * - indexOf(Object o) -> first index. Returns: index or -1.
     * - lastIndexOf(Object o) -> last index. Returns: index or -1.
     *
     * Size / capacity
     * - size() -> number of elements. Returns: int.
     * - isEmpty() -> empty check. Returns: true/false.
     * - capacity() -> current internal array capacity. Returns: int.
     * - ensureCapacity(int minCapacity) -> grows if needed. Returns: void.
     * - trimToSize() -> shrink capacity to size. Returns: void.
     * - setSize(int newSize) -> sets logical size. Returns: void.
     *
     * Traversal
     * - iterator() -> Iterator<E>
     * - listIterator() -> ListIterator<E>
     * - elements() -> Enumeration<E> (legacy)
     *
     * Types you can reference Vector with
     * - Vector<E> v = new Vector<>();
     * - List<E> v = new Vector<>();
     * - Collection<E> v = new Vector<>();
     * - Iterable<E> v = new Vector<>();
     *
     * Vector vs ArrayList
     * - Vector: synchronized methods (legacy, slower in single-thread use).
     * - ArrayList: not synchronized (usually faster for single-thread use).
     * - Prefer ArrayList unless you specifically need legacy Vector API behavior.
     *
     * When to use
     * - Use Vector mainly in legacy systems or when required by old APIs.
     * - Prefer ArrayList + external synchronization for modern code.
     */

    public static void main(String[] args) {
        java.util.Vector<Integer> vector = new java.util.Vector<>();

        vector.add(10);
        vector.add(20);
        vector.addElement(30);
        vector.add(1, 15);

        System.out.println("Vector: " + vector);
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());
        System.out.println("First: " + vector.firstElement());
        System.out.println("Last: " + vector.lastElement());
        System.out.println("Element at index 2: " + vector.get(2));

        vector.set(2, 25);
        vector.remove(Integer.valueOf(15));
        System.out.println("After set/remove: " + vector);

        vector.ensureCapacity(40);
        System.out.println("Capacity after ensureCapacity(40): " + vector.capacity());

        vector.trimToSize();
        System.out.println("Capacity after trimToSize(): " + vector.capacity());

        System.out.println("Iterating with Iterator:");
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Iterating with ListIterator:");
        ListIterator<Integer> listIterator = vector.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("Iterating with Enumeration:");
        Enumeration<Integer> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        List<Integer> listView = vector;
        System.out.println("As List size: " + listView.size());
    }
}
