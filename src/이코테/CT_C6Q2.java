package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이것이 코딩 테스트다 챕터 6 - 2번째 문제 : 성적이 낮은 순서로 학생 출력하기

public class CT_C6Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer[] sb = new StringBuffer[100];

        for(int i=0; i<n; i++) {
            String[] in = br.readLine().split(" ");
            int score = Integer.parseInt(in[1])-1;
            if(sb[score] == null) sb[score] = new StringBuffer(in[0]+" ");
            else sb[score].append(in[0]).append(" ");
        }

        for(StringBuffer s : sb)
            if(s != null) System.out.print(s);
    }
}
