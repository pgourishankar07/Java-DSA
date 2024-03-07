
public class IndianCoins {
    public static void main(String args[]) {

        int notes[] = { 2000, 500, 100, 50, 20, 10, 5, 2, 1 };

        int val = 1059;

        for (int i = 0; i < notes.length; i++) {
            if (val >= notes[i]) {
                System.out.println(notes[i]);
                val -= notes[i];
                i--;
            }
        }

    }
}
