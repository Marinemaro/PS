package BOJ;

import java.io.*;

public class BOJ_17828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32);
        MaroWriter mw = new MaroWriter(65536);

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int x = Integer.parseInt(in[1]);

        if(x<n || x>n*26) mw.write((byte)'!');
        else {
            byte[] b = new byte[n];
            int val = x-n;
            int zCnt = val/25;
            int other = val%25;
            int i;
            for(i=0; i<zCnt; i++) b[n-i-1] = 'Z';
            if(zCnt != n) b[n-i-1] = (byte)('A'+other);
            for(i=0; i<n; i++) mw.write((byte)((b[i]==0)?'A': b[i]));
        }

        mw.flush();
    }
}
