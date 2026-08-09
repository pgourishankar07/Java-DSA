package JCF.Queue.Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class ArrayDequeue {

    /*
     * =================================
     * ArrayDeque (JCF) Study Notes
     * =================================
     *
     * What it is
     * - java.util.ArrayDeque is a resizable-array implementation of Deque.
     * - It supports both queue and stack operations efficiently.
     * - Usually faster than Stack and LinkedList for stack/queue usage.
     * - creating object from Queue, Deque is valid
     *
     * Key points
     * - Double-ended operations at both front and rear.
     * - No null elements allowed.
     * - Not thread-safe.
     * - No random-access by index API like ArrayList.
     *
     * Internal implementation
     * - Backed by a circular array (ring buffer).
     * - Maintains head and tail pointers.
     * - Wrap-around uses modular indexing.
     *
     * Default size and growth
     * - Default constructor creates deque with small initial capacity.
     * - Capacity grows automatically when full.
     * - Growth policy is implementation detail; rely only on amortized O(1)
     * adds/removes at ends.
     *
     * Common constructors
     * - ArrayDeque() -> empty deque.
     * - ArrayDeque(int numElements) -> with initial capacity hint.
     * - ArrayDeque(Collection<? extends E> c) -> copy from another collection.
     *
     * Common methods
     *
     * Add at ends
     * - addFirst(E e) -> adds at front. Returns: void.
     * - addLast(E e) -> adds at rear. Returns: void.
     * - offerFirst(E e) -> adds at front safely. Returns: true.
     * - offerLast(E e) -> adds at rear safely. Returns: true.
     * - add(E e) -> same as addLast for queue use. Returns: true.
     * - offer(E e) -> same as offerLast. Returns: true.
     *
     * Read head/tail without removing
     * - getFirst() -> first element. Returns: element (or throws exception).
     * - getLast() -> last element. Returns: element (or throws exception).
     * - peekFirst() -> first element safely. Returns: element or null.
     * - peekLast() -> last element safely. Returns: element or null.
     * - element() -> queue head. Returns: element (or throws exception).
     * - peek() -> queue head safely. Returns: element or null.
     *
     * Remove from ends
     * - removeFirst() -> removes front. Returns: removed element.
     * - removeLast() -> removes rear. Returns: removed element.
     * - pollFirst() -> removes front safely. Returns: removed element or null.
     * - pollLast() -> removes rear safely. Returns: removed element or null.
     * - remove() -> removes queue head. Returns: removed element.
     * - poll() -> removes queue head safely. Returns: removed element or null.
     *
     * Stack-style methods
     * - push(E e) -> pushes at front (stack top). Returns: void. -- internally
     * calls addFirst()
     * - pop() -> pops from front. Returns: removed top element.
     *
     * Search / remove occurrence
     * - contains(Object o) -> existence check. Returns: true/false.
     * - removeFirstOccurrence(Object o) -> removes first match. Returns: true if
     * removed.
     * - removeLastOccurrence(Object o) -> removes last match. Returns: true if
     * removed.
     *
     * Size / status
     * - size() -> number of elements. Returns: int.
     * - isEmpty() -> empty check. Returns: true/false.
     * - clear() -> removes all elements. Returns: void.
     *
     * Traversal
     * - iterator() -> front to rear iterator.
     * - descendingIterator() -> rear to front iterator.
     *
     * Types you can reference it with
     * - ArrayDeque<E> d = new ArrayDeque<>();
     * - Deque<E> d = new ArrayDeque<>();
     * - Queue<E> q = new ArrayDeque<>();
     * - Collection<E> c = new ArrayDeque<>();
     *
     * ArrayDeque vs LinkedList (as Deque)
     * - ArrayDeque: usually faster and more memory-efficient for stack/queue
     * operations.
     * - LinkedList: node-based, may be useful when frequent iterator removals in
     * middle are needed.
     *
     * When to use
     * - Use ArrayDeque for stack replacement (instead of Stack).
     * - Use ArrayDeque for queue/deque operations in most single-threaded cases.
     * - Avoid when you need null elements or thread-safe operations without
     * external synchronization.
     * - thread safe : ConcurrentLinkedDequeue
     *
     * Complexity (typical)
     * - add/remove/peek at both ends: O(1) amortized
     * - contains/removeFirstOccurrence/removeLastOccurrence: O(n)
     */

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addLast(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.offerLast(30);

        System.out.println("Deque: " + deque);
        System.out.println("First: " + deque.getFirst());
        System.out.println("Last: " + deque.getLast());
        System.out.println("Peek first: " + deque.peekFirst());
        System.out.println("Peek last: " + deque.peekLast());

        System.out.println("Poll first: " + deque.pollFirst());
        System.out.println("Poll last: " + deque.pollLast());
        System.out.println("After poll operations: " + deque);

        deque.push(99);
        System.out.println("After push(99): " + deque);
        System.out.println("Pop: " + deque.pop());
        System.out.println("After pop: " + deque);

        System.out.println("Contains 20: " + deque.contains(20));
        System.out.println("Size: " + deque.size());

        System.out.println("Iterator (front to rear):");
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Descending iterator (rear to front):");
        Iterator<Integer> descending = deque.descendingIterator();
        while (descending.hasNext()) {
            System.out.println(descending.next());
        }

        Deque<Integer> dequeView = deque;
        Queue<Integer> queueView = deque;
        System.out.println("As Deque size: " + dequeView.size());
        System.out.println("As Queue head peek: " + queueView.peek());
    }
}
