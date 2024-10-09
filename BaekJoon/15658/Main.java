package bj_15658_연산자끼워넣기2;

import java.util.*;
import java.io.*;

public class Main {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] arr, op, select;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_15658_연산자끼워넣기2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        select = new int[N - 1];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new int[4];

        for(int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
        br.close();
    }

    static void perm(int idx) {
        if(idx == N - 1) {
            int res = arr[0];
            for(int i = 0; i < N - 1; i++) {
                if(select[i] == 0) {
                    res += arr[i + 1];
                } else if (select[i] == 1) {
                    res -= arr[i + 1];
                } else if(select[i] == 2) {
                    res *= arr[i + 1];
                } else if(select[i] == 3) {
                    if(res < 0) {
                        res = (Math.abs(res) / arr[i + 1]) * -1;
                    } else {
                        res /= arr[i + 1];
                    }
                }
            }
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(op[i] != 0) {
                op[i]--;
                select[idx] = i;
                perm(idx + 1);
                op[i]++;
            }
        }
    }
}
