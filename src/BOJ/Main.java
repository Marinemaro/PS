package BOJ;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<i; j++) System.out.print(' ');
            for(int j=0; j<n*2-i*2-1; j++) System.out.print('*');
            System.out.println();
        }

        for(int i=0; i<n-1; i++) System.out.print(' ');
        System.out.println('*');

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-2-i; j++) System.out.print(' ');
            for(int j=0; j<i*2+3; j++) System.out.print('*');
            System.out.println();
        }
    }
}
