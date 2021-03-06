package TEST;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        int v = map.get(br.readLine());
        if(v!=0) sb.append(v);
        v = map.get(br.readLine());
        sb.append(v);
        v = map.get(br.readLine());
        if(sb.toString().charAt(0)!='0') sb.append("0".repeat(Math.max(0, v)));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }
}