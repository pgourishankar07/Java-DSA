
import java.io.File;

public class DeleteExample {
    public static void main(String[] args) {
        File file = new File("demo.txt");
        if (file.delete()) {
            System.out.println("Deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete.");
        }
    }
}
