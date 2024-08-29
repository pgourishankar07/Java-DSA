package packages;

public class Calci2 extends Calci {

    public Calci2(int n1, int n2) {
        super(n1, n2);
    }

    public void getNum(int n1, int n2) {
        // multi(); // you cant access this because it is private (only that class can
        // access)
        System.out.println(sub(n1, n2));// this can be accessed because it is in default
        get();
    }

}
