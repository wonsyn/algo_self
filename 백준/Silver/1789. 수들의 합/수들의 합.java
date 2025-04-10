import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        Stack<Long> stack = new Stack<>();
        long num = 1;
        int cnt = 0;
        long sum = 0;
        while(sum != S) {
            if(sum + num > S) {
                sum -= stack.pop();
                cnt--;
            } else {
                sum += num;
                stack.push(num++);
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}