package BOJ;

import java.io.IOException;

/*
문제 해결 아이디어
1. 인덱스에 직접 접근하는 방식으로, 그 수가 나온 적이 있으면 그 인덱스의 요소를 true 로 변경한다.
2. 현재 인덱스가 true 값을 가진다면, 나온 적이 있다는 의미이므로 그 인덱스를 출력버퍼에 저장한다.
 */

public class BOJ_10867 {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 256, false);
        MaroWriter mw = new MaroWriter(65536);

        int n = mr.nextInt();
        boolean[] a = new boolean[2001];
        for(int i=0; i<n; i++) a[mr.nextInt()+1000] = true;
        for(int i=0; i<2001; i++) if(a[i]) mw.write(i-1000+" ");
        mw.flush();
    }
}
