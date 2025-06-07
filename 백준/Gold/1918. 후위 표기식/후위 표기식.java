import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pre = br.readLine();
        Stack<Character> op = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < pre.length(); i++) {
            char cur = pre.charAt(i);

            if('A' <= cur && cur <= 'Z') {
                sb.append(cur);
            } else if(cur == '(') {
                op.push(cur);
            } else if(cur == ')') {
                while(!op.isEmpty() && op.peek() != '(') {
                    sb.append(op.pop());
                }
                op.pop();
            } else {
                while(!op.isEmpty() && check(op.peek()) >= check(cur)) {
                    sb.append(op.pop());
                }
                op.push(cur);
            }
        }

        while(!op.isEmpty()) {
            sb.append(op.pop());
        }

        System.out.println(sb);
        br.close();
    }

    public static int check(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0;
    }
}
