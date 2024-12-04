import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dir = {{-1, 0}, {0, -1}};

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int d = 0; d < 2; d++) {
                    int preX = i + dir[d][0];
                    int preY = j + dir[d][1];
                    if(0 < preX && preX <= N && 0 < preY && preY <= N) {
                        arr[i][j] += arr[preX][preY];
                    }
                }
                arr[i][j] -= arr[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}