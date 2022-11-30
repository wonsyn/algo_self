package bj_21313_문어;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N - 1; i += 2) {
            sb.append("1 2 ");
        }

        if(N % 2 != 0) {
            sb.append(3);
        }

        System.out.println(sb);
    }
}
