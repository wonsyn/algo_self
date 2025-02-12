import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[][] jy = new char[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                jy[i][j] = s.charAt(j);
            }
        }
        int state = Integer.parseInt(br.readLine());
        char[][] mirror = new char[N][N];
        if(state == 2) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    mirror[i][N - j - 1] = jy[i][j];
                }
            }
        } else if(state == 3) {
            for(int j = 0; j < N; j++) {
                for(int i = 0; i < N; i++) {
                    mirror[N - i - 1][j] = jy[i][j];
                }
            }
        } else {
            mirror = jy;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(mirror[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}