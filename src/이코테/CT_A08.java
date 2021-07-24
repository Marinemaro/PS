package 이코테;

import java.io.*;
import java.util.Arrays;

// 이것이 코딩 테스트다 부록 - 8번째 문제 : 문자열 재정렬

public class CT_A08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        char[] arr = in.toCharArray();
        Arrays.sort(arr);
        int sum = 0;

        for(char c : arr)
            if(c >= '0' && c <= '9') sum+=c-'0';
            else System.out.print(c);

        if(sum>0) System.out.println(sum);
    }
}
