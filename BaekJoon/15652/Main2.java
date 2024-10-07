package bj_15652_N과M4;

import java.util.*;
import java.io.*;

public class Main2 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_15652_N과M4/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        recursion(0, 1);
        System.out.println(sb);
        br.close();
    }

    static void recursion(int idx, int start) {
        if(idx == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N + 1; i++) {
            arr[idx] = i;
            recursion(idx + 1, i);
        }
    }
}
