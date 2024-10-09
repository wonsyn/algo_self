package bj_14225_부분수열의합;

import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] arr;
    static boolean[] visited, isPossible;


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_14225_부분수열의합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        int max = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }
        isPossible = new boolean[max + 2];

        comb(0, 0);
        for(int i = 1; i < isPossible.length; i++) {
            if(!isPossible[i]) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }

    static void comb(int start, int sum) {
        isPossible[sum] = true;

        for(int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}
