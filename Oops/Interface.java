// Interface
interface Shape {
    void print(); // only declare no body is written inside the interface
}

interface Rectangle {
    void area();
}

/**
 * Calculator Interface
 */
interface Calculator {
    int operation(int a, int b);

}

// Class implementing the interface
class Printer implements Shape, Rectangle {
    // Implementation of the interface method
    public void print() {
        System.out.println("All Shapes");
    }

    public void area() {
        System.out.println("Area of the rectangle ");
    }
}

public class Interface {
    public static void main(String[] args) {
        // Creating an instance of the class
        Printer printer = new Printer();

        // Calling the method from the interface
        printer.print();
        printer.area();

        // /____________________________________

        Calculator sub = new Calculator() {
            public int operation(int a, int b) {
                return a - b;
            }
        };
        Calculator add = (a, b) -> a + b;

        System.out.println(sub.operation(5, 2));
        System.out.println(add.operation(5, 2));
    }
}
