package bj_15655_N과M6;

import java.util.*;
import java.io.*;

public class Main2 {
    static int N, M;
    static int[] arr, num;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_15655_N과M6/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        comb(0, 0);
        System.out.println(sb);
        br.close();
    }

    static void comb(int idx, int start) {
        if(idx == M) {
            for(int i = 0; i < M; i++) sb.append(arr[i]).append(" ");

            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++) {
            arr[idx] = num[i];
            comb(idx + 1, i + 1);
        }
    }
}
