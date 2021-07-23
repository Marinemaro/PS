package 이코테;

import java.io.*;
import java.util.Arrays;

// 이것이 코딩 테스트다 부록 - 2번째 문제 : 곱하기 혹은 더하기

public class CT_A02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] arr = new int[s.length()];
        for(int i=0; i<arr.length; i++) arr[i] = s.charAt(i)-'0';
        Arrays.sort(arr);

        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]<=1 || sum<=1) {
                while (arr[i] == 0) i++;
                sum += arr[i];
            }
            else sum*=arr[i];
        }

        System.out.println(sum);
    }
}
