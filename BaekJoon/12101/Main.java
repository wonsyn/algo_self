package bj_12101_123더하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, count;
    static boolean flag;
    static String ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        flag = false;
        calc(0, "");

        System.out.println(ans == null ? -1 : ans);
    }

    public static void calc(int sum, String exp) {
        if(sum > N || flag) return;
        if(sum == N) {
            count++;
            if(count == K) {
                flag = true;
                ans = exp.substring(0, exp.length() - 1);
            }
            return;
        }
        calc(sum + 1, exp + "1+");
        calc(sum + 2, exp + "2+");
        calc(sum + 3, exp + "3+");
    }
}
