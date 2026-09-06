import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello %s and welcome!", "Hii");
        String a = Arrays.toString(args);
        System.out.println(a);

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }


        EnumClass enumObj = EnumClass.MONDAY;

        System.out.println("Enum Value: " + enumObj);

        for(EnumClass e : EnumClass.values()) {
            System.out.println(e.ordinal() + " : " + EnumClass.valueOf("MONDAY"));
        }

    }

}