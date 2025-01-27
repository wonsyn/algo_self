import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] now = new int[3];
        int[] mission = new int[3];
        int[] ans = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        for(int i = 0; i < 3; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), ":");
        for(int i = 0; i < 3; i++) {
            mission[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 2; i > 0; i--) {
            if(mission[i] < now[i]) {
                mission[i] += 60;
                mission[i - 1]--;
            }
            ans[i] = mission[i] - now[i];
        }
        ans[0] = mission[0] - now[0];
        if(ans[0] < 0) ans[0] += 24;

        for(int i = 0; i < 3; i++) {
            if(ans[i] < 10) sb.append("0");
            sb.append(ans[i]);
            if(i != 2) {
                sb.append(":");
            }
        }
        System.out.println(sb);
        br.close();
    }
}