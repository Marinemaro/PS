package BOJ;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int[] arr = new int[in.length];
        for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(in[i]);
        Arrays.sort(arr);
        for(int i : arr) System.out.print(i+" ");
    }
}
