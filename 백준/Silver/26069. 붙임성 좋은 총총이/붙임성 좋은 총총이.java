import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        set.add("ChongChong");

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            if(set.contains(s1) || set.contains(s2)) {
                set.add(s1);
                set.add(s2);
            }
        }

        System.out.println(set.size());
        br.close();
    }
}