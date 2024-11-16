import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] tri = new int[N][];
        for(int i = 0; i < N; i++) {
            tri[i] = new int[i + 1];
        }

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < tri[i].length; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < tri[i].length; j++) {
                if(j == 0) {
                    tri[i][j] += tri[i - 1][j];
                } else if(j == tri[i].length - 1) {
                    tri[i][j] += tri[i - 1][j - 1];
                } else {
                    tri[i][j] += Math.max(tri[i - 1][j - 1], tri[i - 1][j]);
                }
            }
        }

        int max = tri[N - 1][0];
        for(int i = 1; i < N; i++) {
            max = Math.max(max, tri[N - 1][i]);
        }

        System.out.println(max);
        br.close();
    }
}