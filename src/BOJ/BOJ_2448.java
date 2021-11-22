package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class BOJ_2448 {
    static byte[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MaroWriter mw = new MaroWriter(65536);
        int n = Integer.parseInt(br.readLine());
        map = new byte[n][n*2-1];
        f(n, 0, n-1);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n*2-1; j++) mw.write((byte)(map[i][j]=='*'?'*':' '));
            mw.newLine();
        }
        mw.flush();
    }
    static void f(int n, int r, int c) {
        if(n==3) setTriangle(r, c);
        else {
            f(n/2, r, c);
            f(n/2, r+n/2, c+n/2);
            f(n/2, r+n/2, c-n/2);
        }
    }
    static void setTriangle(int r, int c) {
        map[r][c] = '*';
        map[r+1][c+1] = '*';
        map[r+1][c-1] = '*';
        for(int i=0; i<5; i++) map[r+2][c+i-2] = '*';
    }
    static class MaroWriter {
        private final OutputStream out = System.out;
        private final byte[] b;
        private final int sz;
        private int bufferIdx;
        public MaroWriter(int sz) { this.b = new byte[this.sz=sz]; }
        public void write(byte b) throws IOException {
            if(bufferIdx == sz) flushBuffer(); this.b[bufferIdx++] = b;
        }
        public void flush() throws IOException { if(bufferIdx > 0) flushBuffer(); out.flush(); }
        private void flushBuffer() throws IOException { out.write(b, 0, bufferIdx); bufferIdx = 0; }
        public void newLine() throws IOException{ write((byte)'\n'); }
    }
}
