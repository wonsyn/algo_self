import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int d = Integer.parseInt(br.readLine());
            int ans = 1;
            while(true) {
                if(d < ans * ans + ans) {
                    ans--;
                    break;
                }
                ans++;
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}