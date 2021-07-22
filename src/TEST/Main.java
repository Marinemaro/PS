package TEST;

import BOJ.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 10, true);
        MaroWriter mw = new MaroWriter(65536);

        int cnt = 0;
        int n = mr.nextInt();
        int k = mr.nextInt();

        while(n>1) {
            if(n%k==0) {
                n/=k;
                cnt++;
            }
            else {
                int m = n%k;
                n-=m;
                cnt+=m;
            }
        }

        mw.write(cnt);
        mw.newLine();
        mw.flush();
    }
}

