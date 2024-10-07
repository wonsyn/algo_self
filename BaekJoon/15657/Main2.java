package bj_15657_N과M8;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, M;
    static int[] arr, num;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_15657_N과M8/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        recursion(0, 0);
        System.out.println(sb);
        br.close();
    }

    static void recursion(int idx, int start) {
        if(idx == M) {
            for(int i = 0; i < M; i++) sb.append(arr[i]).append(" ");

            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++) {
            arr[idx] = num[i];
            recursion(idx + 1, i);
        }
    }
}
