package bj_1339_단어수학;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] alphabet;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_1339_단어수학/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        alphabet = new int[26];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int s = 0; s < str.length(); s++) {
                alphabet[str.charAt(s) - 'A'] += (int)Math.pow(10, str.length() - 1 - s);
            }
        }

        Arrays.sort(alphabet);
        int max = 0;
        for(int i = 25, num = 9; i >= 0; i--) {
            if(alphabet[i] == 0) break;
            max += alphabet[i] * num--;
        }

        System.out.println(max);
        br.close();
    }
}
