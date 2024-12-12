import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = 0, T = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            S += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            T += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(S, T));
        br.close();
    }
}