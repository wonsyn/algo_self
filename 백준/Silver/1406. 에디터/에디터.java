import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for(int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);

            if(c == 'L') {
                if(!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if(c == 'D') {
                if(!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if(c == 'B') {
                if(!left.isEmpty()) {
                    left.pop();
                }
            } else {
                left.push(st.nextToken().charAt(0));
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!left.isEmpty()) {
            right.push(left.pop());
        }

        while(!right.isEmpty()) {
            ans.append(right.pop());
        }
        System.out.println(ans);
        br.close();
    }
}
