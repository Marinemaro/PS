package test;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main.MaroReader mr = new Main.MaroReader(65536, true);
        Main.MaroWriter mw = new Main.MaroWriter(65536);

        int n = mr.nextInt();
        int m = mr.nextInt();

        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) set.add(mr.nextString());
        for (int i = 0; i < m; i++) {
            String str = mr.nextString();
            if (set.contains(str)) list.add(str);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (String s : list) sb.append(s).append("\n");
        mw.write(sb.toString());
        mw.flush();
    }
    // BOJ.test.Main 하단에 고정.
    public static class MaroReader {
        private final static int MAX_STR = 21;
        private final InputStream in = System.in;
        private final byte[] b;
        private final boolean isNatural;
        private final int sz;
        private int s, idx, rCnt;
        public MaroReader(int sz, boolean isNatural) {
            this.b = new byte[this.sz=sz];
            this.isNatural = isNatural;
        }
        private void refill() throws IOException {
            rCnt = in.read(b, idx=0, sz);
            if(rCnt<0) b[0] = -1;
        }
        private byte read() throws IOException {
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
            byte[] str = new byte[MAX_STR];
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
    public static class MaroWriter {
        private final OutputStream out = System.out;
        private final byte[] b;
        private final int sz;
        private int bufferIdx;
        MaroWriter(int sz) { this.b = new byte[this.sz=sz]; }
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
}

