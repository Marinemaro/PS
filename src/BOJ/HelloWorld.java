package BOJ;

import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        Main.MaroWriter mr = new Main.MaroWriter(256);
        mr.write("Hello world!");
        mr.flush();
    }
}
