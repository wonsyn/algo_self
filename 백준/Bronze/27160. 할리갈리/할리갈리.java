import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            map.put(name, map.getOrDefault(name, 0) + cnt);
        }

        Set<String> keys = map.keySet();
        for(String s : keys) {
            if(map.get(s) == 5) {
                System.out.println("YES");
                br.close();
                return;
            }
        }

        System.out.println("NO");
        br.close();
    }
}