package BOJ;

import java.io.*;

/*
문제 해결 아이디어
1. 스택 두 개를 생성하고, 하나는 입력받은 수들을 저장(s1)하고, 나머지 하나는 1~n까지 오름차순으로 숫자를 저장(s2)한다.
2. s2가 비어있지 않고, s2의 top과 s1의 top이 같은 값이라면, top 포인터를 증감하면서 서로 같은 동안 "-"를 sb에 저장한다.
3. 모든 연산이 끝나고 s2의 top이 -1값이 아니라면 s2에 요소가 존재한다는 의미이므로 "NO" 출력, 맞다면 sb에 저장된 문자열을 출력한다.
 */

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 10, true);
        MaroWriter mw = new MaroWriter(65536);
        StringBuilder sb = new StringBuilder();
        int n = mr.nextInt();
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        int t1 = 0;
        int t2 = -1;
        for(int i=0; i<n; i++) s1[i] = mr.nextInt();
        for(int i=1; i<=n; i++) {
            s2[++t2] = i;
            sb.append("+\n");
            while(t2>=0 && s2[t2] == s1[t1]) {
                s2[t2--] = 0;
                s1[t1++] = 0;
                sb.append("-\n");
            }
        }
        mw.write(t2<0?sb.toString():"NO");
        mw.flush();
    }
}
