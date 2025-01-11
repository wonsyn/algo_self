import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = 1;
        int ans = 0;

        for(int i = 0; i < N; i++) {
            if(Integer.parseInt(st.nextToken()) == 1) {
                ans += p++;
            } else {
                p = 1;
            }
        }

        System.out.println(ans);
        br.close();
    }
}