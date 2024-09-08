import java.util.ArrayList;

public class Genericss {
    static class CustomList<T> {
        ArrayList<T> arr = new ArrayList<>();

        void add(T data) {
            arr.add(data);
        }

        T get(int i) {
            return arr.get(i);
        }

        boolean isEmpty() {
            return arr.isEmpty();
        }

        void printArray(T[] array) {
            for (T element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        @Override
        public String toString() {
            return "CustomList [arr=" + arr + "]";
        }

    }

    public static void main(String[] args) {
        // CustomList<String> list = new CustomList<>();
        // list.add("Bunty");
        // list.add("Ram");
        // list.add("Rupali");

        // list.printArray(new String[] { "adf", "asd", "er" });

        // System.out.println(list);

    }
}

/*
 * 
 * Generics -- it helps to create classes interfaces methids with type safety by
 * passing type of data as a parameter , before this we were using Object class
 * which covers all subclass like Integer,Float,etc but it has lead to unsafe
 * casting. Generics solve this problem by allowing you to define the data type
 * only when needed, keeping everything type-safe at compile-time.
 * 
 * 
 * 
 * Bounded Type Parameters -- class NumberBox<T extends Number> { // T must be a
 * subclass of Number for example Integer,Float,Double are allowed but not
 * String,Character
 * 
 * Generic Interfaces --
 * 
 * interface MyGenericInterface<T> {
 * T doSomething(T value);
 * }
 * 
 * // Implementation of generic interface
 * class MyGenericClass implements MyGenericInterface<String> {
 * 
 * @Override
 * public String doSomething(String value) {
 * return "Hello, " + value;
 * }
 * }
 * 
 * Wildcard in Generics (?) -- Consider a scenario where you want to process
 * lists of different types (e.g., List<Integer>, List<Double>, or even
 * List<Number>). Without wildcards, you'd have to write a separate method for
 * each type. Wildcards allow you to work with generic types without specifying
 * the exact type, offering both flexibility and type safety.
 * 
 * public static void printList(List<?> list) {
 * for (Object element : list) {
 * System.out.print(element + " ");
 * }
 * System.out.println();
 * }
 */
