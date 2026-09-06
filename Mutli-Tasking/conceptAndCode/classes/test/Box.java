package classes.test;

import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public abstract class Box {
    static{
        System.out.println("Box class loaded!");
    }
    public static int rate = getRate();
    public static int getRate(){
        System.out.println("Got executed inside");
        return 10;
    }
    public static void main(String[] args) {
        System.out.println("Box main method executed!");
    }

}
