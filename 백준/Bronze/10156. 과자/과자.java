import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        int ans = p - Integer.parseInt(st.nextToken());
        if(ans <= 0) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
        br.close();
    }
}