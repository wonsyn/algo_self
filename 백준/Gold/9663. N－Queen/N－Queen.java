import java.io.*;

public class Main{
    static int[] arr;
    static int cnt, N;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = 0;

        check(0);

        System.out.println(cnt);
        br.close();
    }

    static void check(int n) {
        if(n == N) {
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[n] = i;
            if(possible(n)) {
                check(n + 1);
            }
        }
    }

    static boolean possible(int n) {
        for(int i = 0; i < n; i++) {
            if(arr[i] == arr[n]) {
                return false;
            } else if(Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}