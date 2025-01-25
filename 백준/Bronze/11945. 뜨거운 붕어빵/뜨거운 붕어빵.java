import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int n = 0; n < N; n++) {
            String str = br.readLine();
            for(int m = M - 1; m >= 0; m--) {
                sb.append(str.charAt(m));
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}