package BOJ;

import java.io.*;
import java.util.ArrayList;

/*
문제 해결 아이디어
1. 규칙을 보고, "마지막 자릿수는 바로 앞 자릿수보다 작다" 라는 성질을 캐치할 수 있다.
2. 또한, 집합 {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} 에서 공집합이 아닌 임의의 부분집합을 만들었을 때,
   해당 집합에 대응되는 '감소하는 수'는 무조건 1개로 고정되게 된다.
   ex.) {1, 3, 7, 8} = 8731, {1, 5, 9} = 951
3. 따라서 감소하는 수는 2^10-1개밖에 존재하지 않음을 알 수 있고, (n<=10)의 경우 n번째 '감소하는 수'는 n이라는 것이 성립하므로
   위에서 범위 밖의 수를 필터링하여 속도를 개선할 수 있다.
4. 범위 안에 해당하는 n이 입력되었을 경우엔, ArrayList를 생성하고, 0~9번 인덱스를 0~9로 초기화해준다.
5. 이제 i번째 값을 10으로 나눈 나머지(i번째 값의 마지막 자릿수)를 구하고,
   이 값보다 작을 동안 list에 현재값을 왼쪽으로 한 자릿수 밀고 j를 마지막 자릿수로 하는 값을 저장한다.
6. 만약 n과 list.size()-1이 같다면 list.get(n)이 가능하므로, 이를 출력하면 정답이다.
 */

public class BOJ_1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n<=10 || n>1022) {
            System.out.print(n<=10?n:-1);
            return;
        }

        ArrayList<Long> list = new ArrayList<>();
        for(int i=0; i<10; i++) list.add((long)i);

        for(int i=0;;i++) {
            long mod = list.get(i)%10;
            for(int j=0; j<mod; j++) {
                list.add(list.get(i)*10+ j);
                if(n == list.size()-1) {
                    System.out.println(list.get(n));
                    return;
                }
            }
        }
    }
}
