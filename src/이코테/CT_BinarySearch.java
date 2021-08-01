package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 이것이 코딩 테스트다 챕터 7 : 이진 탐색

public class CT_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);    // array size
        Integer k = Integer.parseInt(in[1]);    // target

        Integer[] arr = new Integer[n];
        in = br.readLine().split(" ");
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(in[i]);
        Arrays.sort(arr);

        int res = bSearch(arr, k);
        System.out.println(res<0?"N/A":res+1);
    }
    public static <T extends Comparable<T>> int bSearch(T[] arr, T key) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            int comp = arr[mid].compareTo(key);
            if(comp == 0) return mid;
            else if(comp<0) lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }
}
