package bj_11728_배열합치기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] a, b, result;
        int idxA, idxB, cnt;

        st = new StringTokenizer(br.readLine());
        a = new int[Integer.parseInt(st.nextToken())];
        b = new int[Integer.parseInt(st.nextToken())];
        result = new int[a.length + b.length];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a.length; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b.length; i++) b[i] = Integer.parseInt(st.nextToken());

        for(idxA = 0, idxB = 0, cnt = 0; cnt < result.length; cnt++) {
            if(idxA >= a.length) {
                result[cnt] = b[idxB++];
                continue;
            }
            if(idxB >= b.length) {
                result[cnt] = a[idxA++];
                continue;
            }

            if(a[idxA] < b[idxB]) {
                result[cnt] = a[idxA++];
            } else if(a[idxA] >= b[idxB]) {
                result[cnt] = b[idxB++];
            }
        }

        for(int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
