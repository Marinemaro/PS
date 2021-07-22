package TEST;

import BOJ.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 10, true);
        MaroWriter mw = new MaroWriter(65536);
        int n = mr.nextInt();
        int m = mr.nextInt();
        int k = mr.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = mr.nextInt();
        Arrays.sort(arr);

        int cnt = m/(k+1)*k+m%(k+1);

        int ans = 0;
        ans += arr[arr.length-1]*cnt;
        ans += arr[arr.length-2]*(m-cnt);

        mw.write(ans);
        mw.newLine();
        mw.flush();
    }
}

