public class practice1 {
    public static void main(String args[]) {
        Complex a = new Complex(2, 5);
        // Complex b = new Complex(4, 3);

        a.add(4, 3);
    }
}

class Complex {
    int real, img;

    Complex(int real, int img) {
        this.real = real;
        this.img = img;
    }

    void add(int real, int img) {
        this.real = this.real + real;
        this.img = this.img + img;
        System.out.println("Now the complex number is : " + this.real + " + " + this.img + " i ");
    }
}