import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            if(Integer.parseInt(s.substring(2)) <= 90) {
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}