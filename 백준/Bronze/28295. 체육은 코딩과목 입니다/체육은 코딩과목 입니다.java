import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] dir = new char[4];
        dir[0] = 'N'; dir[1] = 'E'; dir[2] = 'S'; dir[3] = 'W';

        int now = 0;
        for(int i = 0; i < 10; i++) {
            now += Integer.parseInt(br.readLine());
            now %= 4;
        }

        System.out.println(dir[now]);
        br.close();
    }
}