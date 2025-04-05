import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int h = 0, t = 0, w = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while(h < 24) {
            if(t + A <= M) {
                t += A;
                w += B;
            } else {
                t -= C;
                if(t < 0) t = 0;
            }
            h++;
        }

        System.out.println(w);
        br.close();
    }
}