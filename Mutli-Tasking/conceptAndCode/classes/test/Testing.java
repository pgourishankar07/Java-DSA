package classes.test;

import java.util.Objects;

public class Testing {

    public class Testing2{
        static{
            System.out.println("Hi from Testing 2");
        }
    }

    public static void main(String[] args) {
        Box.getRate();
        Testing.Testing2 t ;
    }
}
