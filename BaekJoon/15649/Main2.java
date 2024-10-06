package bj_15649_N과M1;

import java.util.*;
import java.io.*;

public class Main2 {
    static StringBuilder sb;
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_15649_N과M1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];

        perm(0);
        System.out.println(sb);
        br.close();
    }

    public static void perm(int idx) {
        if(idx == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[idx] = i + 1;
                perm(idx + 1);
                visited[i] = false;
            }
        }
    }
}
