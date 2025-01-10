import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0;
        int max = -1;

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            cnt -= Integer.parseInt(st.nextToken());
            cnt += Integer.parseInt(st.nextToken());

            max = Math.max(cnt, max);
        }

        System.out.println(max);
        br.close();
    }
}