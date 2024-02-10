//Poly- many ; morphism - forms

class Pen {
    String color;
    String type;

    Pen() {
    }

    Pen(String c, String t) {
        this.color = c;
        this.type = t;
    }

    // Polymorphism happens in two ways 1.function overloading(compile time)
    // maximise this thing
    // 2.function overriding(run time) minnimise this thing

    // function overloading due to different 1.data types 2.return types 3.No. of
    // parameters

    public void printInfo(String color) {
        System.out.println("You got " + color);
    }

    public void printInfo(String color, int num) {
        System.out.println("Price of the " + color + " Pen is : " + num);
    }

    public void printInfo(int num) {
        System.out.println("I want " + num + " Pens");
    }

    public boolean printInfo(int num, int n) {
        return num == n;
    }

    public void write() {
        System.out.println("Write something using " + this.type);
    }
}

public class Polymorphism {
    public static void main(String args[]) {

        Pen pen1 = new Pen();
        pen1.color = "Black";
        pen1.type = "Ballpoint pen";
        pen1.write();

        Pen pen2 = new Pen("Blue", "Gel pen");
        pen2.write();

        pen2.printInfo(5);
        pen2.printInfo("Green", 5);
        pen2.printInfo("Brown");
        System.out.println(pen2.printInfo(5, 5));

    }

}
