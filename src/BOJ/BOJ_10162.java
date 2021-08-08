package BOJ;

import java.io.*;

public class BOJ_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a = n/300;
        n%=300;
        int b = n/60;
        n%=60;
        int c = n/10;
        n%=10;

        System.out.println((n!=0)?-1:a+" "+b+" "+c);
    }
}