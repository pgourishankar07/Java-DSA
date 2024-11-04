public class Generics {
    static class Gen<T> {
        T val; // you need to declare it as private, or else obj.val = "some other data type"
               // and use get(),set()

        Gen(T v) {
            val = v;
        }
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Gen<Integer> g = new Gen<>(5);
        System.out.println(g.val);
        Gen<String> g1 = new Gen<>("bubnty");
        System.out.println(g1.val);

        Integer[] intArray = { 1, 2, 3, 4, 5 };
        String[] stringArray = { "one", "two", "three", "four", "five" };
        printArray(intArray); // Output: 1 2 3 4 5
        printArray(stringArray); // Output: one two three four five
    }
}
