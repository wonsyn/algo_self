import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            s1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            s2.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for(int s : s1) {
            if(!s2.contains(s)) cnt++;
        }
        for(int s : s2) {
            if(!s1.contains(s)) cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}