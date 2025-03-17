import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N ; i++) {
            String s = br.readLine();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = String.valueOf(chars);
            set.add(s);
        }

        System.out.println(set.size());
        br.close();
    }
}