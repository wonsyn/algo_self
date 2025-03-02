import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            String s = br.readLine();
            for(int j = i % 2 == 0 ? 0 : 1; j < 8; j += 2) {
                if(s.charAt(j) == 'F') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }
}