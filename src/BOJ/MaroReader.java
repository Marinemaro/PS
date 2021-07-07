package BOJ;

import java.io.IOException;
import java.io.InputStream;

public class MaroReader {
    private final InputStream in = System.in;
    private final byte[] b;
    private final boolean isNatural;
    private final int sz;
    private final int strMax;
    private int s, idx, rCnt;
    public MaroReader(int sz, int max, boolean isNatural) {
        this.b = new byte[this.sz=sz];
        this.strMax = max;
        this.isNatural = isNatural;
    }
    private void refill() throws IOException {
        rCnt = in.read(b, idx=0, sz);
        if(rCnt<0) b[0] = -1;
    }
    public byte read() throws IOException {
        if(idx >= rCnt) refill(); return b[idx++];
    }
    public int nextInt() throws IOException {
        int a;
        byte b=read();
        if(isNatural) {
            a=b-'0';
            while((b=read())>='0' && b<='9') a=a*10+b-'0';
            return a;
        } else {
            boolean isNeg = b=='-';
            if(isNeg) b=read();
            a=b-'0';
            while((b=read())>='0' && b<='9') a=a*10+b-'0';
            return isNeg?-a:a;
        }
    }
    public byte[] nextBytes() throws IOException {
        byte[] str = new byte[strMax];
        s = 0;
        byte b = read();
        if(b == -1) return null;
        str[s++]=b;
        while((b=read())>' ' && b<0x7F) str[s++]=b;
        return str;
    }
    public String nextString() throws IOException {
        StringBuilder sb = new StringBuilder();
        byte b = read();
        if(b == -1) return null;
        do sb.append((char)b);
        while((b=read())>' ' && b<0x7F);
        return sb.toString();
    }
    public int getS() {
        return s;
    }
}