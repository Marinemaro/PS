package BOJ;

import java.util.*;
import java.io.*;

/*
문제 해결 아이디어
1. 데크 두 개를 생성 (스택 두 개로도 풀 수 있지만, 출력의 편의를 위해 데크를 사용함)
2. L이 입력되면 커서를 왼쪽으로 한 칸 옮기므로, 왼쪽 데크의 마지막에 있는 문자를 오른쪽 데크의 처음으로 이동.
3. D가 입력되면 커서를 오른쪽으로 한 칸 옮기므로, 오른쪽 데크의 처음에 있는 문자를 왼쪽 데크의 마지막으로 이동.
4. B가 입력되면 커서 왼쪽에 있는 문자를 삭제하므로, 왼쪽 데크의 마지막에 있는 문자를 삭제.
5. P가 입력되면 커서 왼쪽에 문자를 추가하므로, 왼쪽 데크의 끝에 문자를 추가.
6. 최종적으로 왼쪽 데크와 오른쪽 데크의 요소들을 맨 앞부터 출력하면 정답이다.
 */

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 100001, true);
        MaroWriter mw = new MaroWriter(65536);
        Deque<Byte> l = new ArrayDeque<>();
        Deque<Byte> r = new ArrayDeque<>();
        for(byte b : mr.nextBytes()) {
            if(b == 0) break;
            l.add(b);
        }
        int n = mr.nextInt();
        for(int i=0; i<n; i++) {
            byte b = mr.read();
            switch(b) {
                case 'L':
                    if(!l.isEmpty()) r.addFirst(l.removeLast());
                    break;
                case 'D':
                    if(!r.isEmpty()) l.addLast(r.removeFirst());
                    break;
                case 'B':
                    if(!l.isEmpty()) l.removeLast();
                    break;
                case 'P':
                    mr.read();
                    l.addLast(mr.read());
                    break;
            }
            if(i!=n-1) mr.read();
        }
        while(!l.isEmpty()) mw.write(l.removeFirst());
        while(!r.isEmpty()) mw.write(r.removeFirst());
        mw.flush();
    }
}
