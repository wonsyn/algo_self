package bj_15656_N과M7;

import java.util.*;
import java.io.*;

public class Main2 {
    static int N, M;
    static int[] arr, num;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_15656_N과M7/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        perm(0);

        System.out.println(sb);
        br.close();
    }

    static void perm(int idx) {
        if(idx == M) {
            for(int i = 0; i < M; i++) sb.append(arr[i]).append(" ");

            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[idx] = num[i];
            perm(idx + 1);
        }
    }
}
