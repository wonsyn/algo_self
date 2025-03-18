import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 1) {
                int x = Integer.parseInt(st.nextToken());
                map.put(Integer.parseInt(st.nextToken()), x);
            } else {
                sb.append(map.get(Integer.parseInt(st.nextToken()))).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}