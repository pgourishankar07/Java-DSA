package packages;

public class Calci { // if u dont give "public" then u cant access when importing this package
    int n1;
    int n2;

    public Calci(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int add() { // after importing this package you can access anywhere
        return n1 + n2;
    }

    protected void get() { // "protected" only the derived class(child) even if they are in different
                           // packages.
        // and the java files inside packages folder
        // can access this method
        // which is
        // Calci2
        multi();
        System.out.println(n1 + " " + n2);
    }

    int sub(int n1, int n2) { // "default" only inside this class and java files inside this package
        return n1 - n2;
    }

    private void multi() { // "private" only inside this class
        System.out.println("Multiply");
    }

}
