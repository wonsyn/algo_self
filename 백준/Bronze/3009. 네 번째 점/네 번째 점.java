import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] points = new int[4][2];
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map1.put(a, map1.getOrDefault(a, 0) + 1);
            map2.put(b, map2.getOrDefault(b, 0) + 1);
        }

        Set<Integer> key1 = map1.keySet();
        Set<Integer> key2 = map2.keySet();
        StringBuilder sb = new StringBuilder();
        for(int k : key1) {
            if(map1.get(k) % 2 != 0) {
                sb.append(k).append(" ");
                break;
            }
        }
        for(int k : key2) {
            if(map2.get(k) % 2 != 0) {
                sb.append(k);
                break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}