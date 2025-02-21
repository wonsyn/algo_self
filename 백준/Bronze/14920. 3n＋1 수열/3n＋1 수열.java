import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        int n = 1;

        while(c != 1) {
            if(c % 2 == 0) {
                c = c / 2;
            } else {
                c = 3 * c + 1;
            }
            n++;
        }

        System.out.println(n);
        br.close();
    }
}