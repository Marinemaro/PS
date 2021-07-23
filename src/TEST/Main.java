package TEST;

import BOJ.*;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 21, true);
        MaroWriter mw = new MaroWriter(65536);

        int n = mr.nextInt();
        int[] fears = new int[n];
        for(int i=0; i<n; i++) fears[i] = mr.nextInt();
        Arrays.sort(fears);

        int cnt = 0;    // 총 그룹의 개수 (카운트)
        int members = 1;    // 그룹원의 수 (카운트2)
        for(int f : fears) {    // 0번 멤버부터 모든 공포도를 체크
            if(members >= f) {  // 현재 그룹원의 공포도보다 그룹원의 명수가 더 많다면
                cnt++;          // 그룹 체결 후 그룹원의 수 초기화
                members = 1;
            } else members++;   // 아니라면 그룹원의 수 증가
        }

        mw.write(cnt);  // 답안 출력
        mw.newLine();
        mw.flush();
    }
}