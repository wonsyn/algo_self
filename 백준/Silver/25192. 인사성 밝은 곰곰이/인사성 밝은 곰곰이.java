import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int ans = 0;
        for(int n = 0; n < N; n++) {
            String s = br.readLine();
            if(s.equals("ENTER")) {
                ans += set.size();
                set.clear();
            } else {
                set.add(s);
            }
        }

        ans += set.size();
        System.out.println(ans);
        br.close();
    }
}