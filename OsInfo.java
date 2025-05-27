import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OsInfo {
    public static void main(String[] args) {

        // Get OS info
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("Architecture: " + System.getProperty("os.arch"));

        // get Java runtime info
        Runtime runtime = Runtime.getRuntime();

        System.out.println("Available Processors: " + runtime.availableProcessors());
        System.out.println("Free Memory: " + runtime.freeMemory());
        System.out.println("Total Memory: " + runtime.totalMemory());
        System.out.println("Max Memory: " + runtime.maxMemory());

        // to exe. system cmds
        Process process;
        try {
            process = Runtime.getRuntime().exec("uptime");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // get process info
        ProcessHandle current = ProcessHandle.current();
        ProcessHandle.Info info = current.info();

        System.out.println("PID: " + current.pid());
        System.out.println("Command: " + info.command().orElse("Unknown"));
        System.out.println("Start Time: " + info.startInstant().orElse(null));
        System.out.println("User: " + info.user().orElse("Unknown"));

    }
}