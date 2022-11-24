package bj_15657_N과M_8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr, printArr;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        printArr = new int[M];

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(arr);

        dfs(0, 0);
    }

    static void dfs(int startIdx, int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                System.out.print(printArr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=startIdx; i<N; i++) {
            printArr[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
}