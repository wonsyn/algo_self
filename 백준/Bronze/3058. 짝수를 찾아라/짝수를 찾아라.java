import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 7; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 0) {
                    sum += num;
                    min = Math.min(min, num);
                }
            }

            sb.append(sum).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}