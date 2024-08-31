import java.util.ArrayList;

class test {
    public static void main(String[] args) {
        ArrayList a = new ArrayList<>();
        a.add('a');
        a.add("abc");
        a.add(3);

        // System.out.println(a);
        // System.out.println((int) ('a'));

        String s1 = new String("hello");
        // Intern the new String object
        String s2 = s1.intern();

        // Print initial values
        System.out.println("s1: " + s1); // This prints "hello"
        System.out.println("s2: " + s2); // This prints "hello"

        // Change s1 to a new string literal
        s1 = "hell";

        // Print after changing s1
        System.out.println("After changing s1:");
        System.out.println("s1: " + s1); // This prints "hell"
        System.out.println("s2: " + s2); // This still prints "hello"

    }
}