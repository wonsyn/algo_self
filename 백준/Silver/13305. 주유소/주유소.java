import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[N - 1];
        for(int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] costs = new int[N];
        for(int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int cost = 0;
        for(int i = 0; i < N - 1; i++) {
            int add = 0;
            for(int j = i + 1; j < N - 1; j++) {
                if(costs[i] > costs[j]) {
                    break;
                }
                add++;
            }
            for(int j = 0; j <= add; j++) {
                cost += costs[i] * distance[i + j];
            }
            i += add;
        }

        System.out.println(cost);
        br.close();
    }
}