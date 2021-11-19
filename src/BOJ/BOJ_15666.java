package BOJ;

import java.io.*;
import java.util.Arrays;

public class BOJ_15666 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void f(int[] arr, int[] result, int depth, int m) throws IOException {
        if(depth == m) {
            for(int r : result) bw.write(r+" ");
            bw.newLine();
        }
        else {
            int prev = 0;
            for (int a : arr) {
                if ((depth == 0 || a >= result[depth-1]) && a != prev) {
                    prev = a;
                    result[depth] = a;
                    f(arr, result, depth + 1, m);
                    result[depth] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[] arr = new int[n];
        in = br.readLine().split(" ");
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(in[i]);
        Arrays.sort(arr);
        int[] result = new int[m];
        f(arr, result, 0, m);
        bw.flush();
    }
}
