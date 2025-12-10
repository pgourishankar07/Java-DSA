import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class Revise {
    public static void main(String[] args) {
        System.out.println("Hello");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        Iterator i = arr.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        ConcurrentHashMap map = new ConcurrentHashMap<>(); // instead of using HashTable we can use this which is
                                                           // threadsafe

        // String pool (only for string - by default interning happens) vs Heap (all
        // objects are stored here when u use 'new' keyword )
        String s1 = new String("Hello"); // new object in heap
        String s2 = s1.intern(); // pooled reference - creates "Hello" in string pool
        String s3 = "Hello"; // pooled literal - "Hello" is already created in previous line so just get that
                             // reference

        System.out.println(s1 == s2); // false (heap vs pool)
        System.out.println(s2 == s3);

        // StringBuilder Vs StringBuffer(Thread-safe)
    }
}

/*
 * Traversal ways :
 * 1. For loop (index-based)
 * 2. Enhanced for loop (for-each)
 * 3. Iterator
 * 4. ListIterator (forward & backward)
 * 5. forEach() with Lambda
 * 6. Iterator.forEachRemaining()
 * 7. Streams & parallelStreams
 * 8. Enumeration (legacy)
 * 
 */