package bj_15649_N과M_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] res;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();

        perm(0);

        System.out.print(sb.toString());
    }

    static void perm(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < cnt; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res[cnt] = i + 1;
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
