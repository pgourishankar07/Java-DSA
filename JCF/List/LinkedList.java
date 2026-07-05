
import java.util.Iterator;

public class LinkedList {

    /*
     * =========================
     * LinkedList Study Notes
     * =========================
     *
     * What it is
     * - LinkedList is a doubly linked list implementation of the List interface.
     * - It also implements List and Queue -> Deque, so it supports queue and stack
     * style operations.
     * - creating objet from List, Queue, Deque is valid
     * - Elements are stored in separate nodes instead of a continuous array.
     *
     * Key points
     * - Fast insert/remove at beginning or end
     * - Slow random access by index: O(n)
     * - Allows duplicate values
     * - Preserves insertion order
     * - Allows null values
     *
     * Internal implementation
     * - node stores: item, prev, next
     * - first: reference to head node
     * - last: reference to tail node
     * - size: number of elements
     * - modCount: helps fail-fast iterators detect changes
     *
     * How add works
     * - Create a new node.
     * - Link it with neighboring nodes.
     * - Update first or last if needed.
     * - Increment size.
     *
     * Capacity and growth
     * - LinkedList has no fixed capacity.
     * - It grows node by node as you add elements.
     * - There is no resize threshold like ArrayList.
     * 
     * Types you can use it as
     * - LinkedList<E> -> direct concrete type.
     * - List<E> -> use when you want normal list behavior like get(index),
     * set(index), and indexed insert/remove.
     * - Deque<E> -> use when you want deque, queue, or stack style operations.
     * - Queue<E> -> use when you only need FIFO queue behavior.
     * - Collection<E> -> use when you only need general collection operations.
     * - Stack<E> -> not applicable; java.util.Stack is a different class, not a
     * supertype of LinkedList.
     * 
     * Example declarations
     * - LinkedList<Integer> list = new LinkedList<>();
     * - List<Integer> listView = new LinkedList<>();
     * - Deque<Integer> dequeView = new LinkedList<>();
     * - Queue<Integer> queueView = new LinkedList<>();
     * 
     * Difference by reference type
     * - List view: best when you need indexed access and list methods like
     * add(index, e) and get(index).
     * - Queue view: best when you need FIFO behavior with offer, poll, and peek.
     * - Deque view: best when you need both ends, such as addFirst/addLast,
     * removeFirst/removeLast, or stack methods like push/pop.
     * - Concrete LinkedList view: best when you want access to all
     * LinkedList-specific and inherited methods.
     * 
     * When to use what
     * - Use List when your code should focus on ordered collection behavior with
     * indexing.
     * - Use Queue when the task is message handling, task scheduling, or any FIFO
     * flow.
     * - Use Deque when you need double-ended queue behavior or want to use it like
     * a stack.
     * - Use LinkedList directly when you specifically need its full API and do not
     * want to hide methods behind an interface.
     *
     * Common methods
     *
     * Creation
     * - LinkedList() -> creates an empty list. Returns: LinkedList object.
     * - LinkedList(Collection<? extends E> c) -> copies elements from another
     * collection. Returns: LinkedList object.
     *
     * Add
     * - add(E e) -> inserts element at the end. Returns: true.
     * - addFirst(E e) -> inserts element at the front. Returns: void.
     * - addLast(E e) -> inserts element at the end. Returns: void.
     * - add(int index, E element) -> inserts element at a specific position.
     * Returns: void.
     * - offer(E e) -> adds element at the end for queue use. Returns: true.
     * - offerFirst(E e) -> adds element at the front. Returns: true.
     * - offerLast(E e) -> adds element at the end. Returns: true.
     *
     * Get / peek
     * - get(int index) -> fetches the element at index. Returns: element at that
     * index.
     * - getFirst() -> fetches first element. Returns: first element.
     * - getLast() -> fetches last element. Returns: last element.
     * - peek() -> looks at first element without removing it. Returns: first
     * element or null.
     * - peekFirst() -> looks at first element without removing it. Returns: first
     * element or null.
     * - peekLast() -> looks at last element without removing it. Returns: last
     * element or null.
     *
     * Remove
     * - remove() -> removes and returns the first element. Returns: removed
     * element.
     * - remove(int index) -> removes element at index. Returns: removed element.
     * - remove(Object o) -> removes the first matching object. Returns: true if
     * removed.
     * - removeFirst() -> removes and returns the first element. Returns: removed
     * element.
     * - removeLast() -> removes and returns the last element. Returns: removed
     * element.
     * - poll() -> removes first element safely. Returns: first element or null.
     * - pollFirst() -> removes first element safely. Returns: first element or
     * null.
     * - pollLast() -> removes last element safely. Returns: last element or null.
     * - clear() -> deletes all elements. Returns: void.
     *
     * Search
     * - contains(Object o) -> checks whether an element exists. Returns:
     * true/false.
     * - indexOf(Object o) -> finds first position of an element. Returns: index or
     * -1.
     * - lastIndexOf(Object o) -> finds last position of an element. Returns: index
     * or -1.
     *
     * Size / status
     * - size() -> gives the number of elements. Returns: int.
     * - isEmpty() -> checks whether the list has no elements. Returns: true/false.
     *
     * Array conversion
     * - toArray() -> converts the list to Object[]. Returns: Object[].
     * - toArray(T[] a) -> converts the list to a typed array. Returns: T[].
     *
     * Iteration
     * - iterator() -> gives a simple forward iterator. Returns: Iterator<E>.
     * - descendingIterator() -> iterates from last to first. Returns: Iterator<E>.
     *
     * Bulk operations
     * - addAll(Collection<? extends E> c) -> appends all elements from another
     * collection. Returns: true if list changed.
     * - containsAll(Collection<?> c) -> checks whether all items exist. Returns:
     * true/false.
     * - removeAll(Collection<?> c) -> removes all matching elements. Returns: true
     * if list changed.
     * - retainAll(Collection<?> c) -> keeps only matching elements. Returns: true
     * if list changed.
     *
     * Queue / deque helpers
     * - element() -> gets first element without removing. Returns: first element.
     * - removeFirstOccurrence(Object o) -> removes first matching element. Returns:
     * true if removed.
     * - removeLastOccurrence(Object o) -> removes last matching element. Returns:
     * true if removed.
     * - push(E e) -> pushes element like a stack. Returns: void.
     * - pop() -> removes and returns first element like a stack. Returns: removed
     * element.
     *
     * When to use
     * - Use LinkedList when you do many insertions and removals near the ends.
     * - Avoid it when you need frequent random access by index.
     */

    public static void main(String[] args) {
        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();

        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.addLast(30);
        list.add(2, 15);

        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Index of 15: " + list.indexOf(15));

        list.set(2, 16);
        list.remove(Integer.valueOf(20));
        list.removeFirst();
        list.removeLast();

        System.out.println("After update/remove: " + list);
        System.out.println("Peek: " + list.peek());

        System.out.println("Iterating with iterator:");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.push(99);
        System.out.println("After push: " + list);
        System.out.println("Pop: " + list.pop());
        System.out.println("Final list: " + list);
    }
}
