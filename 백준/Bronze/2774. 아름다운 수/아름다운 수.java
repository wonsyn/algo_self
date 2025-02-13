import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            boolean[] check = new boolean[10];
            String s = br.readLine();
            for(int i = 0; i < s.length(); i++) {
                int n = s.charAt(i) -'0';
                if(!check[n]) check[n] = true;
            }
            int cnt = 0;
            for(int i = 0; i < 10; i++) {
                if(check[i]) cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}