package 이코테;

import java.io.*;

// 이것이 코딩 테스트다 챕터 6 - 1번째 문제 : 위에서 아래로

public class CT_C6Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[100000];
        for(int i=0; i<n; i++) arr[Integer.parseInt(br.readLine())-1]++;
        for(int i=0; i<arr.length; i++) {
            while(arr[i]>0) {
                arr[i]--;
                System.out.print(i+1+" ");
            }
        }
    }
}
