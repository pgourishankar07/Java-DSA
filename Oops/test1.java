import packages.Node;
import packages.Calci2;

public class test1 {
    public static void main(String[] args) {
        Node n = new Node(); // Creating an instance of Node
        n.displayMessage(); // Calling the method from Node class
        Calci2 c = new Calci2(5, 4);
        System.out.println(c.add());
        c.getNum(5, 4);
    }
}