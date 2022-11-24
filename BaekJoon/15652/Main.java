package bj_15652_N과M_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N, M;
    static int[] res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = new int[M];

        comb(0, 0);

        System.out.println(sb.toString());
    }

    static void comb(int start, int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++) {
            res[cnt] = i + 1;
            comb(i, cnt + 1);
        }
    }
}
