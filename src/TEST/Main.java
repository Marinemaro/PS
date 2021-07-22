package TEST;

import BOJ.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 10, true);
        MaroWriter mw = new MaroWriter(65536);
        int money = mr.nextInt();
        int cnt = 0;
        int[] coins = {500, 100, 50, 10};

        for(int c : coins) {
            cnt+=money/c;
            money%=c;
        }

        mw.write(cnt);
        mw.newLine();
        mw.flush();
    }
}

