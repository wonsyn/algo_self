import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int maxN = -1;
        int maxM = -1;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            maxN = Math.max(Integer.parseInt(st.nextToken()), maxN);
        }
        st=  new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            maxM = Math.max(Integer.parseInt(st.nextToken()), maxM);
        }

        System.out.println(maxN + maxM);
        br.close();
    }
}