package JCF.List;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class Stack {

    /*
     * =========================
     * Stack (JCF) Study Notes
     * =========================
     *
     * What it is
     * - java.util.Stack is a legacy stack class in JCF.
     * - It follows LIFO (Last In, First Out).
     * - It extends Vector, so internally it is array-backed and synchronized. --
     * thread safety
     * - creating object from List, Vector is valid
     *
     * Key points
     * - push/pop/peek are stack-style operations.
     * - Thread-safe for single method calls because Vector methods are
     * synchronized.
     * - Generally slower than modern alternatives due to synchronization overhead.
     * - Recommended modern choice for stack behavior: Deque (ArrayDeque).
     *
     * Default size and growth
     * - Default initial capacity comes from Vector: 10.
     * - If capacityIncrement is 0 (default), capacity typically doubles when full.
     * - Growth trigger: size + 1 > current capacity.
     *
     * Internal implementation
     * - Inherited from Vector:
     * - elementData: Object[] backing array
     * - elementCount: current number of elements
     * - capacityIncrement: custom growth step (if set)
     * - Stack top is the last element in the vector.
     *
     * push(element) flow
     * - Check capacity in underlying Vector.
     * - Grow backing array if full.
     * - Add element at the end (top).
     * - Increase size.
     *
     * pop() flow
     * - Read the last element.
     * - Remove it from underlying Vector.
     * - Decrease size and return removed element.
     *
     * Common methods
     *
     * Stack specific
     * - push(E item) -> adds element on top. Returns: pushed element.
     * - pop() -> removes top element. Returns: removed top element.
     * - peek() -> reads top element without removing. Returns: top element.
     * - empty() -> checks whether stack is empty. Returns: true/false.
     * - search(Object o) -> 1-based position from top. Returns: position or -1.
     *
     * Inherited useful methods (Vector/List)
     * - add(E e) -> appends element. Returns: true.
     * - get(int index) -> fetches element by index. Returns: element.
     * - set(int index, E element) -> replaces element. Returns: old element.
     * - remove(int index) -> removes by index. Returns: removed element.
     * - remove(Object o) -> removes first match. Returns: true if removed.
     * - size() -> number of elements. Returns: int.
     * - isEmpty() -> empty check. Returns: true/false.
     * - clear() -> removes all elements. Returns: void.
     * - firstElement() -> first element. Returns: element.
     * - lastElement() -> last element (same as top in stack usage). Returns:
     * element.
     *
     * Capacity helpers (Vector)
     * - ensureCapacity(int minCapacity) -> grows if needed. Returns: void.
     * - trimToSize() -> shrinks capacity to current size. Returns: void.
     * - capacity() -> current internal capacity. Returns: int.
     *
     * Interfaces / types you can reference Stack with
     * - Stack<E> s = new Stack<>();
     * - Vector<E> s = new Stack<>();
     * - List<E> s = new Stack<>();
     * - Stack also behaves as Collection<E>, Cloneable, Serializable, RandomAccess.
     *
     * Stack vs Deque (important)
     * - Stack is legacy and extends Vector.
     * - Deque (ArrayDeque/LinkedList) is preferred for modern stack usage.
     * - For interviews and production, usually write: Deque<Integer> st = new
     * ArrayDeque<>();
     *
     * When to use
     * - Use Stack when learning old JCF APIs or maintaining legacy code.
     * - Prefer Deque for new code that needs stack behavior.
     *
     * Complexity (typical)
     * - push: O(1) amortized
     * - pop: O(1)
     * - peek: O(1)
     * - search: O(n)
     */

    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack);
        System.out.println("Top (peek): " + stack.peek());
        System.out.println("Position of 20 from top: " + stack.search(20));
        System.out.println("Is empty: " + stack.empty());
        System.out.println("Size: " + stack.size());

        int popped = stack.pop();
        System.out.println("Popped: " + popped);
        System.out.println("After pop: " + stack);

        stack.add(40);
        System.out.println("After add(40): " + stack);
        System.out.println("Element at index 1: " + stack.get(1));

        System.out.println("Iterating with Iterator:");
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Iterating with ListIterator:");
        ListIterator<Integer> listIterator = stack.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        List<Integer> listView = stack;
        Vector<Integer> vectorView = stack;
        System.out.println("As List size: " + listView.size());
        System.out.println("As Vector capacity: " + vectorView.capacity());
    }
}
