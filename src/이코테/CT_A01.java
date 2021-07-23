package 이코테;

import java.io.*;
import java.util.Arrays;

// 이것이 코딩 테스트다 부록 - 1번째 문제 : 모험가 길드

public class CT_A01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int[] fears = new int[n];
        for(int i=0; i<n; i++) fears[i] = Integer.parseInt(in[i]);
        Arrays.sort(fears);

        int cnt = 0;    // 총 그룹의 개수 (카운트)
        int members = 1;    // 그룹원의 수 (카운트2)
        for(int f : fears) {    // 0번 멤버부터 모든 공포도를 체크
            if(members >= f) {  // 현재 그룹원의 공포도보다 그룹원의 명수가 더 많다면
                cnt++;          // 그룹 결성 후 그룹원의 수 초기화
                members = 1;
            } else members++;   // 아니라면 그룹원의 수 증가
        }

        System.out.println(cnt);    // 답안 출력
    }
}