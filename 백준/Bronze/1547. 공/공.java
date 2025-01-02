import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        boolean[] cup = new boolean[4];
        cup[1]= true;

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean temp = cup[a];
            cup[a] = cup[b];
            cup[b] = temp;
        }

        for(int i = 1; i <= 3; i++) {
            if(cup[i]) {
                System.out.println(i);
                break;
            }
        }

        br.close();
    }
}