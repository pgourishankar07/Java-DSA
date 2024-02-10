import bank.Bank;

class Shape {
    Shape() {
        System.out.println("Parent class constructor");
    }

    public void area() {
        System.out.println("This contains all the shapes");
    }
}

class Rectangle extends Shape { // you can access all the methods from shape too0
    Rectangle() {
        System.out.println("Base class constructor");
    }

    public void area(int l, int b) {
        System.out.println("The area of rectangle is : " + (l * b));
    }
}

class Circle extends Shape {
    public void area(int r) {
        System.out.println("The area of Circle : " + (3.14 * r * r));
    }
}

public class Inheritance {

    public static void main(String[] args) { // Constructor chaining :
        Rectangle rectangle = new Rectangle(); // whenever an object is created it first calls the parent class
                                               // constructor then the base class constructor
        rectangle.area();
        rectangle.area(3, 2);

        Bank customer1 = new Bank();
        customer1.hello();
    }
}

// Types of inheritance :
// 1.Single level
// 2.Multi level
// 3.Multiple(Interface)
// 4.Hieracheal
// 5.Hybrid
