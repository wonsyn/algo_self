import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min1 = 2222, min2 = 2222;
        for(int i = 0; i < 3; i++) {
            min1 = Math.min(min1, Integer.parseInt(br.readLine()));
        }
        for(int i = 0; i < 2; i++) {
            min2 = Math.min(min2, Integer.parseInt(br.readLine()));
        }

        System.out.println(min1 + min2 - 50);

        br.close();
    }
}