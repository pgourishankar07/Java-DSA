class Pen { // in objects : data -- properties and members -- methods
    String color;
    String type;

    Pen() { // construct object ,no return
    }// constructor name should start with CapLetters and function -- smallLetters

    Pen(String c, String t) {
        this.color = c;
        this.type = t; // tells the function that ehich instance to take
    }

    Pen(Pen p) {
        this.color = p.color;
        this.type = p.type; // it gives a clearity by using 'this' to assign values for the current object
    }

    public void write() {
        System.out.println("Write something using " + this.type);
    }

}

public class BasicOops1 {
    public static void main(String args[]) { // main comes under public class

        Pen pen1 = new Pen();
        pen1.type = "Ball";
        pen1.write();

        // Pen pen1 = new Pen();
        // pen1.color = "Black";
        // pen1.type = "Ballpoint pen";
        // pen1.write();

        Pen pen2 = new Pen("Blue", "Gel pen");
        pen2.write();

        // Pen pen3 = new Pen(pen1); // copy constructor
        // pen3.write();

        // no need of calling destructor in java, garbage collector will remove
        // automatically

    }

}
