package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
문제 해결 아이디어
1. 기본적인 정렬 문제, Arrays.sort() 메소드를 사용해서 정렬한 후 출력한다.
 */

public class BOJ_2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int[] arr = new int[in.length];
        for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(in[i]);
        Arrays.sort(arr);
        for(int i : arr) System.out.print(i+" ");
    }
}
