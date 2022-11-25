package bj_3005_크로스워드퍼즐쳐다보기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String answer = "zzzzzzzzzzzzzzzzzzzz";
        StringBuilder sb;

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] words = new char[r][c];

        for(int i = 0; i < r; i++) words[i] = br.readLine().toCharArray();

        for(int i = 0; i < r; i++) {
            sb = new StringBuilder();
            for(int j = 0; j < c; j++) {
                if(words[i][j] != '#') {
                    sb.append(words[i][j]);
                } else {
                    if(sb.toString().length() >= 2 && sb.toString().compareTo(answer) < 0) {
                        answer = sb.toString();
                    }
                    sb = new StringBuilder();
                }
            }
            if(sb.toString().length() >= 2 && sb.toString().compareTo(answer) < 0) {
                answer = sb.toString();
            }
        }

        for(int i = 0; i < c; i++) {
            sb = new StringBuilder();
            for(int j = 0; j < r; j++) {
                if(words[j][i] != '#') {
                    sb.append(words[j][i]);
                } else {
                    if(sb.toString().length() >= 2 && sb.toString().compareTo(answer) < 0) {
                        answer = sb.toString();
                    }
                    sb = new StringBuilder();
                }
            }
            if(sb.toString().length() >= 2 && sb.toString().compareTo(answer) < 0) {
                answer = sb.toString();
            }
        }

        System.out.print(answer);
    }
}
