package bj_2290_LCDTest;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_2290_LCDTest/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        char[] number = st.nextToken().toCharArray();

        for(int y = 0; y < 2 * s + 3; y++) {
            for(int i = 0; i < number.length; i++) {
                if(y == 0) {
                    if(number[i] != '1' && number[i] != '4') {
                        sb.append(" ").append("-".repeat(s)).append(" ");
                    } else {
                        sb.append(" ".repeat(s + 2));
                    }
                }
                else if(y < (2 * s + 3) / 2) {
                    if(number[i] == '1' || number[i] == '2' || number[i] == '3' || number[i] == '7') {
                        sb.append(" ".repeat(s + 1)).append("|");
                    } else if(number[i] == '4' || number[i] == '8' || number[i] == '9' || number[i] == '0') {
                        sb.append("|").append(" ".repeat(s)).append("|");
                    } else if(number[i] == '5' || number[i] == '6'){
                        sb.append("|").append(" ".repeat(s + 1));
                    }
                } else if(y == (2 * s + 3) / 2) {
                    if(number[i] != '1' && number[i] != '7' && number[i] != '0') {
                        sb.append(" ").append("-".repeat(s)).append(" ");
                    } else {
                        sb.append(" ".repeat(s + 2));
                    }
                } else if(y == 2 * s + 2){
                    if(number[i] != '1' && number[i] != '4' && number[i] != '7') {
                        sb.append(" ").append("-".repeat(s)).append(" ");
                    } else {
                        sb.append(" ".repeat(s + 2));
                    }
                } else if(y > (2 * s + 3) / 2) {
                    if(number[i] == '1' || number[i] == '3' || number[i] == '4' || number[i] == '5' || number[i] == '7' || number[i] == '9') {
                        sb.append(" ".repeat(s + 1)).append("|");
                    } else if(number[i] == '6' || number[i] == '8' || number[i] == '0') {
                        sb.append("|").append(" ".repeat(s)).append("|");
                    } else if(number[i] == '2'){
                        sb.append("|").append(" ".repeat(s + 1));
                    }
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
