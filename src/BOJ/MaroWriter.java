package BOJ;

import java.io.IOException;
import java.io.OutputStream;

public class MaroWriter {
    private final OutputStream out = System.out;
    private final byte[] b;
    private final int sz;
    private int bufferIdx;
    public MaroWriter(int sz) { this.b = new byte[this.sz=sz]; }
    public void write(byte b) throws IOException {
        if(bufferIdx == sz) flushBuffer(); this.b[bufferIdx++] = b;
    }
    public void write(int i) throws IOException {
        byte[] tmp = new byte[11];
        int idx = 0;
        boolean isNeg = i<0;
        if(i==0) tmp[idx++] = '0';
        else while(i!=0) {
            int t=i%10;
            tmp[idx++] = (byte)('0'+(t<0?-t:t));
            i/=10;
        }
        if(isNeg) tmp[idx++] = '-';
        for(int j=idx-1; j>=0; j--) write(tmp[j]);
    }
    public void write(long l) throws IOException {
        byte[] tmp = new byte[20];
        int idx = 0;
        boolean isNeg = l<0;
        if(l==0) tmp[idx++] = '0';
        else while(l!=0) {
            long t=l%10;
            tmp[idx++] = (byte)('0'+(t<0?-t:t));
            l/=10;
        }
        if(isNeg) tmp[idx++] = '-';
        for(int j=idx-1; j>=0; j--) write(tmp[j]);
    }
    public void write(String s) throws IOException {
        byte[] str = s.getBytes();
        write(str, str.length);
    }
    public void write(byte[] str, int length) throws IOException{
        for(int i=0; i<length; i++) write(str[i]);
    }
    public void flush() throws IOException { if(bufferIdx > 0) flushBuffer(); out.flush(); }
    private void flushBuffer() throws IOException { out.write(b, 0, bufferIdx); bufferIdx = 0; }
    public void newLine() throws IOException{ write((byte)'\n'); }
    public void space() throws IOException{ write((byte)' '); }
}