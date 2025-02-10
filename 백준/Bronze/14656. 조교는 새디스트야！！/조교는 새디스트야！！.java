import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(Integer.parseInt(st.nextToken()) != i) {
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}