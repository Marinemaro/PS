package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제 해결 아이디어
1. 입력받은 모든 내용을 저장하고, A에 포함된 문자열들로 어디까지 완성할 수 있는지 체크하는 boolean형 배열을 생성한다.
2. 모든 문자열에는 "" 문자(길이가 0인 문자)가 속한다고 할 수 있으므로, boolean형 배열 0번 인덱스를 true로 초기화해준다.
3. i를 1부터 입력받은 문자열의 length 까지로 하여 큰 반복을 돌며,
   저장된 'A에 포함된 문자열' 의 갯수만큼 작은 반복을 도는데,
   현재 i값이 A에 포함된 문자열 중 하나(str)의 길이보다 크고,
   문자열 S의 i-str.length()번 인덱스부터 시작하여 S의 부분문자열과 str의 모든 문자가 같다면
   i-str.length()번째 위치까지 만들 수 있었는지 확인(able[i-str.length()]가 true라면)한 후
   모두 true라면 현재 위치까지 완성할 수 있다는 의미이므로 able[i]를 true로 바꾼 후 큰 반복을 다시 돌리게 된다.
4. 모든 과정이 끝난 후 able[] 배열의 마지막 요소가 true라면 1, false라면 0을 출력하면 정답이다.
 */

public class BOJ_16500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] lib = new String[n];
        for(int i=0; i<n; i++) lib[i] = br.readLine();

        boolean[] able = new boolean[s.length()+1];
        able[0] = true;

        for(int i=1; i<=s.length(); i++) {
            for(String str : lib) {
                if(i >= str.length() && s.startsWith(str, i-str.length()) && able[i-str.length()]) {
                    able[i] = true;
                    break;
                }
            }
        }

        System.out.println(able[s.length()]?1:0);
    }
}

