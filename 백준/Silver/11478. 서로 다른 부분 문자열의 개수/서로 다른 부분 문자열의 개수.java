import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            for(int cur = 0; cur + i < str.length(); cur++) {
                String s = str.substring(cur, cur + i + 1);
                set.add(s);
            }
        }

        System.out.println(set.size());
        br.close();
    }
}