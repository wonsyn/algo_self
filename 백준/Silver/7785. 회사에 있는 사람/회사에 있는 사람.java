import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String state = st.nextToken();

            if(state.equals("enter")) {
                map.put(name, 1);
            } else {
                map.remove(name);
            }
        }

        Set<String> set = map.keySet();

        ArrayList<String> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}