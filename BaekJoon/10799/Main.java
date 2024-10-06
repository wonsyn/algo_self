package bj_10799_쇠막대기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_10799_쇠막대기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<Character>();

        String str = br.readLine();
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else if(str.charAt(i) == ')') {
                if(str.charAt(i - 1) == '(') {
                    stack.pop();
                    count += stack.size();
                }
                else {
                    stack.pop();
                    count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
