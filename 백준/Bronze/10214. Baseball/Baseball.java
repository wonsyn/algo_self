import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st;
            int Y = 0, K = 0;
            for(int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                Y += Integer.parseInt(st.nextToken());
                K += Integer.parseInt(st.nextToken());
            }

            sb.append(Y > K ? "Yonsei" : Y < K ? "Korea" : "Draw").append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}