package 이코테;

import java.io.*;
import java.util.Arrays;

// 이것이 코딩 테스트다 챕터 7 - 1번째 문제 : 부품 찾기

public class CT_C7Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] in = br.readLine().split(" ");
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(in[i]);

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        in = br.readLine().split(" ");
        for(int i=0; i<m; i++)
            System.out.print(bSearch(arr, Integer.parseInt(in[i]))<0?"no ":"yes ");
    }
    public static int bSearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(arr[mid] == key) return mid;
            else if(arr[mid]<key) lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }
}