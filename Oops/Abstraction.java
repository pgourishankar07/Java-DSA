// Abstract class
abstract class Shape {
    // Abstract method (to be implemented by subclasses)
    abstract void draw();

    // Concrete method
    void display() {
        System.out.println("Displaying the shape.");
    }
}

// Concrete subclass
class Circle extends Shape {
    // Implementation of the abstract method
    void draw() {
        System.out.println("Drawing a circle.");
    }
}

// Concrete subclass
class Rectangle extends Shape {
    // Implementation of the abstract method
    void draw() {
        System.out.println("Drawing a rectangle.");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        // Creating instances of concrete subclasses
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        // Calling methods
        circle.draw();
        circle.display();

        // here you cant create object of class shape
        System.out.println("--------------------");

        rectangle.draw();
        rectangle.display();
    }
}
