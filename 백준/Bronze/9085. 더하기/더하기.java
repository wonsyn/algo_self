import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int i = 0; i < N; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}