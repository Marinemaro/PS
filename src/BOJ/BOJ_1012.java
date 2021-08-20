package BOJ;

import java.io.*;

/*
문제 해결 아이디어
1. 0과 1만 저장되면 되므로 2차원 배열 map을 boolean[][]형으로 생성했다.
2. 배추의 위치가 입력되면 해당 위치의 값을 true로 변경하고,
   완전 탐색을 하여 true를 만나면 dfs()를 호출한 후 인접한 true 값들을 false로 바꿔준다.
3. dfs()를 호출한 횟수를 출력하면 정답이다.
 */

public class BOJ_1012 {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    public static void dfs(boolean[][] map, int x, int y) {
        map[x][y] = false;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny])
                dfs(map, nx, ny);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            int cnt = Integer.parseInt(in[2]);

            boolean[][] map = new boolean[n][m];
            for(int i=0; i<cnt; i++) {
                in = br.readLine().split(" ");
                map[Integer.parseInt(in[0])][Integer.parseInt(in[1])] = true;
            }

            int ans = 0;
            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++)
                    if(map[i][j]) {
                        dfs(map, i, j);
                        ans++;
                    }

            System.out.println(ans);
        }
    }
}
