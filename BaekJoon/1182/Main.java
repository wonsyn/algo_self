package bj_1182_부분수열의합;

import java.util.*;
import java.io.*;

public class Main {
    static int N, S, ans;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_1182_부분수열의합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;

        comb(0);
        System.out.println(ans);
        br.close();
    }

    static void comb(int start) {
        int sum = 0;
        boolean flag = false;
        for(int i = 0; i < N; i++) {
            if(visited[i]) {
                flag = true;
                sum += arr[i];
            }
        }
        if(sum == S && flag) {
            ans++;
        }

        for(int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i + 1);
                visited[i] = false;
            }
        }
    }
}
