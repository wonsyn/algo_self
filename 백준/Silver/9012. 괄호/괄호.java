import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            boolean f = true;
            String s = br.readLine();
            int cnt = 0;

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c == '(') {
                    cnt++;
                } else {
                    if(cnt <= 0) {
                        f = false;
                        break;
                    } else {
                        cnt--;
                    }
                }
            }

            if(cnt > 0) f = false;

            sb.append(f ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
        br.close();
    }
}