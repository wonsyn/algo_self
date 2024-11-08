import java.io.*;

public class Main{
    static char[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        recursion(0, 0, N, 1);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void recursion(int x, int y, int n, int blank) {
        if(blank == 5) {
            for(int i = x; i < x + n; i++) {
                for(int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1) {
            arr[x][y] = '*';
            return;
        }

        int cnt = 0;
        int size = n / 3;
        for(int i = x; i < x + n; i += size) {
            for(int j = y; j < y + n; j += size) {
                recursion(i, j, size, ++cnt);
            }
        }
    }
}