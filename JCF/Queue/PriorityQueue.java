package JCF.Queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

public class PriorityQueue {

    /*
     * ================================
     * PriorityQueue (JCF) Study Notes
     * ================================
     *
     * What it is
     * - java.util.PriorityQueue is a heap-based queue.
     * - Elements are removed by priority, not insertion order.
     * - By default it is a min-heap (smallest element has highest priority).
     * - creating object from Queue is valid
     *
     * Key points
     * - Default ordering: natural order (Comparable).
     * - Custom ordering: provide Comparator.
     * - Allows duplicate values.
     * - Does NOT allow null elements.
     * - Not thread-safe.
     * - Iteration order is not sorted order.
     *
     * Default size and growth
     * - Default initial capacity: 11.
     * - Internal capacity grows automatically when full.
     * - Exact growth formula is implementation detail; do not rely on fixed steps.
     *
     * Internal implementation
     * - Backed by Object[] heap array.
     * - Uses binary heap structure.
     * - Parent-child relation in array:
     * parent(i) = (i - 1) / 2
     * left(i) = 2 * i + 1
     * right(i) = 2 * i + 2
     *
     * add/offer flow
     * - Insert element at end of heap array.
     * - Heapify-up (sift-up) to restore heap order.
     *
     * poll flow
     * - Remove root element (highest priority in heap terms).
     * - Move last element to root.
     * - Heapify-down (sift-down) to restore heap order.
     *
     * Common constructors
     * - PriorityQueue() -> default min-heap, capacity 11.
     * - PriorityQueue(int initialCapacity)
     * - PriorityQueue(Comparator<? super E> comparator)
     * - PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
     * - PriorityQueue(Collection<? extends E> c)
     *
     * Common methods
     *
     * Add / insert
     * - add(E e) -> inserts element. Returns: true (or throws exception).
     * - offer(E e) -> inserts element safely. Returns: true.
     *
     * Access / remove head
     * - peek() -> reads head without removing. Returns: head element or null.
     * - element() -> reads head without removing. Returns: head element (or throws
     * exception).
     * - poll() -> removes head safely. Returns: head element or null.
     * - remove() -> removes head. Returns: head element (or throws exception).
     *
     * Remove/search
     * - remove(Object o) -> removes one matching object. Returns: true if removed.
     * - contains(Object o) -> checks existence. Returns: true/false.
     *
     * Size / state
     * - size() -> number of elements. Returns: int.
     * - isEmpty() -> empty check. Returns: true/false.
     * - clear() -> removes all elements. Returns: void.
     *
     * Conversion / traversal
     * - toArray() -> converts to Object[]. Returns: Object[].
     * - toArray(T[] a) -> converts to typed array. Returns: T[].
     * - iterator() -> returns iterator (not sorted traversal).
     *
     * Types you can reference it with
     * - PriorityQueue<E> pq = new PriorityQueue<>();
     * - Queue<E> pq = new PriorityQueue<>();
     * - Collection<E> pq = new PriorityQueue<>();
     *
     * Min-heap vs max-heap
     * - Min-heap (default): new PriorityQueue<>()
     * - Max-heap: new PriorityQueue<>(Comparator.reverseOrder())
     *
     * When to use
     * - Use when repeatedly extracting min/max efficiently.
     * - Common in Dijkstra, Prim, scheduling, top-k, merge k sorted lists.
     * - If you need strict sorted iteration, use TreeSet/TreeMap or poll
     * repeatedly.
     *
     * Complexity (typical)
     * - offer/add: O(log n)
     * - poll/remove(): O(log n)
     * - peek/element: O(1)
     * - contains/remove(Object): O(n)
     */

    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();

        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);
        minHeap.offer(5);

        System.out.println("Min-heap PQ: " + minHeap);
        System.out.println("Head (peek): " + minHeap.peek());
        System.out.println("Size: " + minHeap.size());
        System.out.println("Contains 20: " + minHeap.contains(20));

        System.out.println("Poll: " + minHeap.poll());
        System.out.println("After poll: " + minHeap);

        System.out.println("Iterating (not sorted guarantee):");
        Iterator<Integer> iterator = minHeap.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);
        maxHeap.offer(5);

        System.out.println("Max-heap head (peek): " + maxHeap.peek());

        Queue<Integer> queueView = minHeap;
        System.out.println("As Queue, size: " + queueView.size());

        System.out.println("Removing all from min-heap in priority order:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
