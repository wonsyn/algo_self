import java.io.*;
import java.util.*;

public class Main {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int number = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int[] center = {N / 2, N / 2};
        int r = N / 2;
        int c = N / 2;
        int d = 0;
        int level = 1;
        int num = 1;

        while(true) {
            arr[r][c] = num;
            if(r == 0 && c == 0) {
                break;
            }


            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(center[0] - level <= nr && nr <= center[0] + level &&
                    center[1] - level <= nc && nc <= center[1] + level) {
                r = nr;
                c = nc;
                num++;
            } else {
                d++;
                if(d == 4) {
                    level++;
                    d = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int ansR = -1, ansC = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
                if(arr[i][j] == number) {
                    ansR = i + 1; ansC = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(ansR).append(" ").append(ansC);

        System.out.println(sb);
        br.close();
    }
}
