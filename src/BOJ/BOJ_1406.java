package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        Main.MaroReader mr = new Main.MaroReader(65536, 100001, true);
        Main.MaroWriter mw = new Main.MaroWriter(65536);
        Deque<Byte> l = new ArrayDeque<>();
        Deque<Byte> r = new ArrayDeque<>();
        for(byte b : mr.nextBytes()) {
            if(b == 0) break;
            l.add(b);
        }
        int n = mr.nextInt();
        for(int i=0; i<n; i++) {
            byte b = mr.read();
            switch(b) {
                case 'L':
                    if(!l.isEmpty()) r.addLast(l.removeLast());
                    break;
                case 'D':
                    if(!r.isEmpty()) l.addLast(r.removeLast());
                    break;
                case 'B':
                    if(!l.isEmpty()) l.removeLast();
                    break;
                case 'P':
                    mr.read();
                    l.addLast(mr.read());
                    break;
            }
            if(i!=n-1) mr.read();
        }
        while(!l.isEmpty()) mw.write(l.removeFirst());
        while(!r.isEmpty()) mw.write(r.removeLast());
        mw.flush();
    }
}
