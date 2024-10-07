package bj_15654_N과M5;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, M;
    static int[] arr, num;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_15653_N과M5/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        visited = new boolean[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        perm(0);

        System.out.println(sb);
        br.close();
    }

    static void perm(int idx) {
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
                arr[idx] = num[i];
                perm(idx + 1);
                visited[i] = false;
            }
        }
    }
}
