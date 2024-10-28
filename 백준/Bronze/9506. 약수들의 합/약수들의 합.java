import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int num = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            if(num == -1) break;
            Queue<Integer> q = new ArrayDeque<>();

            sb.append(num).append(" = ");

            for(int i = 1; i <= num / 2; i++) {
                if(num % i == 0) {
                    q.offer(i);
                }
            }
            int sum = 0;
            while(!q.isEmpty()) {
                int plus = q.poll();
                sum += plus;
                if(sum > num) break;
                sb.append(plus).append(q.isEmpty()? "" : " + ");
            }

            if(q.isEmpty() && sum == num) {
                System.out.println(sb);
            } else {
                System.out.println(num + " is NOT perfect.");
            }
        }

        br.close();
    }
}