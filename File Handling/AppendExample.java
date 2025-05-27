
import java.io.FileWriter;
import java.io.IOException;

public class AppendExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("demo.txt", true); // 'true' for append
            writer.write("\nAppended content.");
            writer.close();
            System.out.println("Data appended.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
