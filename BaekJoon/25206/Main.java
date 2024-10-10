package bj_25206_너의평점은;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_25206_너의평점은/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double total = 0;
        double sum = 0;
        for(int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            double s;
            String str = st.nextToken();
            if(str.equals("A+")) {
                s = 4.5;
            } else if (str.equals("A0")) {
                s = 4.0;
            } else if (str.equals("B+")) {
                s = 3.5;
            } else if (str.equals("B0")) {
                s = 3.0;
            } else if (str.equals("C+")) {
                s = 2.5;
            } else if (str.equals("C0")) {
                s = 2.0;
            } else if (str.equals("D+")) {
                s = 1.5;
            } else if (str.equals("D0")) {
                s = 1.0;
            } else if (str.equals("F")) {
                s = 0.0;
            } else {
                continue;
            }
            total += score;
            sum += score * s;
        }

        System.out.println(sum / total);
//        System.out.printf("%.6f", sum / total); // 출력 포맷 지정 (소수점 6자리까지)
        br.close();
    }
}
