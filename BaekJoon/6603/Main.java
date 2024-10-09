package bj_6603_로또;

import java.util.*;
import java.io.*;

public class Main {
    static int[] arr, res;
    static int K;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_6603_로또/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0) break;

            arr = new int[K];
            visited = new boolean[K];
            for(int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            res = new int[6];
            comb(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void comb(int idx, int start) {
        if(idx == 6) {
            for(int i = 0; i < 6; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < K; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res[idx] = arr[i];
                comb(idx + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
