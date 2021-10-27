import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
public class demo {

    public class DemoJava {
        public static void main(String[] args) throws IOException  {
            FileOutputStream fileOutputStream = null;
            fileOutputStream = new FileOutputStream("D://output.txt");
            fileOutputStream.write(65);
        }
    }
}