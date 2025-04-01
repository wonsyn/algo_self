import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int e = 0, o = 0;
        for(int i = 0; i < s.length(); i++) {
            if((s.charAt(i) - '0') % 2 == 0) {
                e++;
            } else {
                o++;
            }
        }

        System.out.println(e > o ? 0 : (e < o) ? 1 : -1);
        br.close();
    }
}