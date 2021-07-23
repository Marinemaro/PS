package TEST;

import BOJ.*;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 21, true);
        MaroWriter mw = new MaroWriter(65536);

        byte[] b = mr.nextBytes();
        int[] arr = new int[mr.getS()];
        for(int i=0; i<arr.length; i++) arr[i] = b[i]-'0';
        Arrays.sort(arr);

        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]<=1 || sum<=1) {
                while (arr[i] == 0) i++;
                sum += arr[i];
            }
            else sum*=arr[i];
        }

        mw.write(sum);
        mw.newLine();
        mw.flush();
    }
}