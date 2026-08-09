
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList {

    /*
     * =========================
     * ArrayList Study Notes
     * =========================
     *
     * What it is
     * - A resizable array implementation of the List interface.
     * - Stores elements in an internal Object[] array.
     * - it implements List ibnterface only
     * - creating object from List and Queue is valid
     * List<LinkedList<Integer>> stk = new ArrayList<>(); -- valid
     * Queue<LinkedList<Integer>> stk = new ArrayList<>(); -- invalid
     *
     * Key points
     * - Fast random access by index: O(1), get/set/add/remove frm anywhere
     * - Add at end: amortized O(1)
     * - Insert/remove in middle or front: O(n)
     * - Allows duplicate values
     * - Preserves insertion order
     * - Allows null values
     *
     * Default size and growth
     * - new ArrayList<>() starts with an empty shared array.
     * - On first add, capacity becomes 10.
     * - When full, capacity grows by about 1.5x.
     * - Growth formula: newCapacity = oldCapacity + (oldCapacity >> 1)
     * - Resize happens when size + 1 > current capacity.
     *
     * Internal implementation
     * - elementData: backing Object[] array
     * - size: number of stored elements
     * - modCount: helps fail-fast iterators detect changes
     *
     * add(element) flow
     * - Check whether there is space in elementData.
     * - If full, allocate a larger array.
     * - Copy old values into the new array.
     * - Store the new value and increment size.
     *
     * Common methods
     *
     * Creation
     * - ArrayList() -> creates an empty list. Returns: ArrayList object.
     * - ArrayList(int initialCapacity) -> creates a list with starting capacity.
     * Returns: ArrayList object.
     * - ArrayList(Collection<? extends E> c) -> copies elements from another
     * collection. Returns: ArrayList object.
     *
     * Add
     * - add(E e) -> inserts an element at the end. Returns: true.
     * - add(int index, E element) -> inserts an element at a specific position.
     * Returns: void.
     * - addAll(Collection<? extends E> c) -> appends all elements from another
     * collection. Returns: true if list changed.
     * - addAll(int index, Collection<? extends E> c) -> inserts all elements at a
     * given position. Returns: true if list changed.
     *
     * Get / set
     * - get(int index) -> fetches the element at the given index. Returns: element
     * at that index.
     * - set(int index, E element) -> replaces the old element with a new one.
     * Returns: previous element.
     *
     * Remove
     * - remove(int index) -> removes the element at the given index. Returns:
     * removed element.
     * - remove(Object o) -> removes the first matching object. Returns: true if
     * removed.
     * - clear() -> deletes all elements. Returns: void.
     *
     * Search
     * - contains(Object o) -> checks whether an element exists. Returns:
     * true/false.
     * - indexOf(Object o) -> finds the first position of an element. Returns: index
     * or -1.
     * - lastIndexOf(Object o) -> finds the last position of an element. Returns:
     * index or -1.
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
     * - listIterator() -> gives a bidirectional iterator. Returns: ListIterator<E>.
     * - spliterator() -> supports splitting for parallel traversal. Returns:
     * Spliterator<E>.
     *
     * Bulk operations
     * - containsAll(Collection<?> c) -> checks whether all items exist. Returns:
     * true/false.
     * - removeAll(Collection<?> c) -> removes all matching elements. Returns: true
     * if list changed.
     * - retainAll(Collection<?> c) -> keeps only matching elements. Returns: true
     * if list changed.
     *
     * Capacity helpers
     * - ensureCapacity(int minCapacity) -> grows backing array if needed. Returns:
     * void.
     * - trimToSize() -> shrinks backing array to the current size. Returns: void.
     *
     * When to use
     * - Use ArrayList when you need fast indexing and mostly append at the end.
     * - Avoid it when you do many insertions/removals near the front or middle.
     *
     * EXTRA Doubts (Important)
     *
     * 1) Why declaration style matters ---- <AnyInterfaceOrClass<AnyClass>> obj =
     * new <ChildClassOfOuterShell> example : // Queue<LinkedList<Integer>> stk =
     * new Stack<>(); -- not vlaid
     * OuterInterfaceOrClass<InnerClass> obj = new ChildClassOfOuterShell<>();
     * --valid
     * valid in java
     * - Core principle: Program to an interface, not an implementation.
     * - Interface reference gives flexibility; concrete reference gives tighter
     * control.
     *
     * 2) Interface-to-class vs class-to-class
     * - List<ArrayList<Integer>> m1 = new ArrayList<>();
     * Meaning: reference type is List, runtime object is ArrayList.
     * You can call List methods only (add, get, size, remove, ...).
     * - ArrayList<ArrayList<Integer>> m2 = new ArrayList<>();
     * Meaning: both reference and object are ArrayList.
     * You can call List methods + ArrayList-only methods (ensureCapacity,
     * trimToSize).
     *
     * 3) Flexibility vs rigidity
     * - If method signature uses List<...>, you can swap implementation later:
     * List<ArrayList<Integer>> matrix = new LinkedList<>();
     * - If method signature uses ArrayList<...>, switching to LinkedList later
     * needs refactoring.
     *
     * 4) Valid representations for nested list structures
     * - List<ArrayList<Integer>> matrix = new ArrayList<>();
     * - List<ArrayList<Integer>> matrix = new LinkedList<>();
     * - ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
     * - LinkedList<ArrayList<Integer>> matrix = new LinkedList<>();
     * - List<List<Integer>> matrix = new ArrayList<>();
     * - List<List<Integer>> matrix = new LinkedList<>();
     * - List<LinkedList<Integer>> matrix = new LinkedList<>();
     *
     * 5) Outer vs inner type (onion rule)
     * - In A<B>, A is outer container type, B is element type.
     * - Example: List<ArrayList<Integer>> matrix = new LinkedList<>();
     * Outer runtime container = LinkedList of rows.
     * Each row element type = ArrayList<Integer>.
     *
     * 6) List vs LinkedList reference (same runtime object, different visible API)
     * - List<ArrayList<Integer>> x = new LinkedList<>();
     * Can call only List contract methods.
     * - LinkedList<ArrayList<Integer>> y = new LinkedList<>();
     * Can also call LinkedList-specific methods (addFirst, removeLast, ...).
     *
     * 7) Matrix design choices
     * - List<ArrayList<Integer>> with outer LinkedList:
     * Good when rows are inserted/removed often at ends, but row access still needs
     * traversal.
     * - List<LinkedList<Integer>>:
     * Good when inner rows also change frequently at ends/front.
     * Weak for random column access because inner get(c) is O(c).
     * - List<ArrayList<Integer>>:
     * Usually best for matrix-like problems with frequent random access per row.
     *
     * 8) Complexity quick view
     * - Inner ArrayList row: get(col) O(1), add-end amortized O(1), insert-front
     * O(m).
     * - Inner LinkedList row: get(col) O(m), add/remove at ends O(1).
     * - Outer LinkedList addFirst/removeFirst O(1), outer get(row) O(r).
     *
     * 9) Practical rule
     * - Default choice for most grid/DP work: List<List<Integer>> matrix = new
     * ArrayList<>();
     * - Use outer LinkedList only when row insertion/deletion patterns demand it.
     * - Use concrete ArrayList reference only when you need
     * ensureCapacity/trimToSize.
     *
     * 10) Diagrams (Provided Representations)
     *
     * A) List<ArrayList<Integer>> matrix = new LinkedList<>();
     *
     * [Matrix Reference]
     * |
     * v
     * (LinkedList Node 1) ---> (LinkedList Node 2) ---> (LinkedList Node 3)
     * | | |
     * v v v
     * [ArrayList Row 1] [ArrayList Row 2] [ArrayList Row 3]
     * [1, 2, 3, 4] [5, 6, 7, 8] [9, 10, 11, 12]
     *
     * B) Choice comparison
     *
     * Choice A: List<ArrayList<Integer>> matrix = new LinkedList<>();
     *
     * [Outer LinkedList] ---> (Row Node 1) -------------> (Row Node 2)
     * | |
     * v v
     * [ArrayList Row] [ArrayList Row]
     * [10 | 20 | 30 | 40] [50 | 60 | 70 | 80]
     * (Fast Random Access) (Fast Random Access)
     *
     * Choice B: List<LinkedList<Integer>> matrix = new LinkedList<>();
     *
     * [Outer LinkedList] ---> (Row Node 1) -------------> (Row Node 2)
     * | |
     * v v
     * [LinkedList Row] [LinkedList Row]
     * (10)->(20)->(30) (50)->(60)->(70)
     * (Sequential Access) (Sequential Access)
     *
     * C) Onion rule (read nested types left to right)
     *
     * Line 1:
     * List<ArrayList<Integer>> matrix = new LinkedList<>();
     * ^--- outer reference type is List
     * ^------------------ inner element type is ArrayList<Integer>
     *
     * Line 2:
     * LinkedList<ArrayList<Integer>> matrix = new LinkedList<>();
     * ^-------- outer reference type is LinkedList
     * ^--------------- inner element type is ArrayList<Integer>
     *
     * Key idea:
     * - sort(Comparator)
     * - replaceAll(UnaryOperator)
     * - Left side controls compile-time accessible methods.
     * - Right side controls actual runtime object.
     * - subList(fromInd, toInd) -- any change in this will change the main list
     * - thread safe : CopyOnWriteArrayList
     */

    public static void main(String[] args) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        list.add(10);

        list.add(20);
        list.add(30);
        list.add(1, 15);
        list.add(null);

        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Index of 30: " + list.indexOf(30));

        list.set(2, 25);
        list.remove(Integer.valueOf(15));
        list.remove(list.size() - 1);

        System.out.println("After set/remove: " + list);
        System.out.println("Is empty: " + list.isEmpty());

        Object[] array = list.toArray();
        System.out.println("toArray(): " + Arrays.toString(array));

        Integer[] typedArray = list.toArray(new Integer[0]);
        System.out.println("toArray(T[]): " + Arrays.toString(typedArray));

        System.out.println("Iterating with iterator:");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Iterating with listIterator:");
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
