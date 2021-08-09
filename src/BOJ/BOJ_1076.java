package BOJ;

import java.io.*;
import java.util.LinkedHashMap;

/*
문제 해결 아이디어
1. 링크드 해쉬맵에 모든 데이터를 저장
2. 첫 값이 0이면 무시, 0이 아니라면 sb에 저장
3. 둘째 값은 0이더라도 sb에 저장
4. sb에 저장된 수가 0이 아니라면 현재 값만큼 0을 채움
5. sb에 저장된 문자열이 정답이다.
 */

public class BOJ_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        int v = map.get(br.readLine());
        if(v!=0) sb.append(v);
        v = map.get(br.readLine());
        sb.append(v);
        v = map.get(br.readLine());
        if(sb.toString().charAt(0)!='0') sb.append("0".repeat(Math.max(0, v)));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }
}
