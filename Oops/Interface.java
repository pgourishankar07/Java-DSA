// Interface
interface Shape {
    void print(); // only declare no body is written inside the interface
}

interface Rectangle {
    void area();
}

// Class implementing the interface
class Printer implements Shape {
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
    }
}
