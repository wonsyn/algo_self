import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length() / 2; i++) {
            stack.push(s.charAt(i));
        }
        
        int i = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;
        boolean ans = false;
        while(!stack.isEmpty()) {
            char c = stack.pop();
            if(c != s.charAt(i)) {
                break;
            }
            i++;
        }
        if(stack.isEmpty() && i == s.length()) {
            ans = true;
        }
        
        System.out.println(ans ? 1 : 0);
        br.close();
    }
}