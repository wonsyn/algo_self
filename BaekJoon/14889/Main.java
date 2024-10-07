package bj_14889_스타트와링크;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] selected;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_14889_스타트와링크/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        selected = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.println(min);
        br.close();
    }

    static void comb(int idx, int start) {
        if(idx == N / 2) {
            int st = 0, li = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(selected[i] && selected[j]) {
                        st += arr[i][j];
                    } else if(!selected[i] && !selected[j]){
                        li += arr[i][j];
                    }
                }
            }

            min = Math.min(min, Math.abs(st - li));
            return;
        }

        for(int i = start; i < N; i++) {
            selected[i] = true;
            comb(idx + 1, i + 1);
            selected[i] = false;
        }
    }
}
