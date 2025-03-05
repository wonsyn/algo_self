import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String ex = st.nextToken();

            map.put(ex, map.getOrDefault(ex, 0) + 1);
        }
        Set<String> keys = map.keySet();
        ArrayList<Ex> list = new ArrayList<>();
        for(String k : keys) {
            list.add(new Ex(k, map.get(k)));
        }
        list.sort((o1, o2) -> o1.ex.compareTo(o2.ex));
        StringBuilder sb = new StringBuilder();
        for(Ex ex : list) {
            sb.append(ex).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    static class Ex {
        String ex;
        int cnt;
        Ex(String ex, int cnt) {
            this.ex = ex; this.cnt = cnt;
        }

        public String toString() {
            return ex + " " + cnt;
        }
    }
}