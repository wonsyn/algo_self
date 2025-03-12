import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int play = game == 'Y' ? 2 : game == 'F' ? 3 : 4;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        System.out.println(set.size() / (play - 1));
        br.close();
    }
}