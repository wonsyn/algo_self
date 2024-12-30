import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int min = -1;
        int sum = 0;

        for(int i = A; i <= B; i++) {
            int num = (int)Math.sqrt(i);
            if(num * num == i) {
                if(min == -1) {
                    min = i;
                }
                sum += i;
            }
        }

        if(sum != 0) {
            System.out.println(sum);
        }
        System.out.println(min);
        br.close();
    }
}