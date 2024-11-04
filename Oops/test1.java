import packages.Node;
import packages.Calci2;

class Shapes {

    void area() {
        System.out.println("Override your Area");
    }

}

class Rectangle extends Shapes {
    void area(int l, int b) {
        System.out.println("Area : " + " " + (l * b));
    }
}

class Circle extends Shapes {
    void area(int r) {
        System.out.println("Area : " + " " + (2 * 3.14 * r * r));
    }
}

public class test1 {
    public static void main(String[] args) {
        // Node n = new Node(); // Creating an instance of Node
        // n.displayMessage(); // Calling the method from Node class
        // Calci2 c = new Calci2(5, 4);
        // System.out.println(c.add());
        // c.getNum(5, 4);

        Rectangle rec = new Rectangle();
        rec.area(5, 4);

        Circle cir = new Circle();
        cir.area(5);
    }
}