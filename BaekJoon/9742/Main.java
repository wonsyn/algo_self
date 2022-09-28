package bj_9742_순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String original, answer = null;
    static int dist, count;
    static boolean[] visited;
    static char[] strArr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            sb = new StringBuilder();
            original = st.nextToken();
            dist = Integer.parseInt(st.nextToken());

            count = 0;
            strArr = original.toCharArray();
            visited = new boolean[original.length()];

            perm(0);

            System.out.println(original + " " + dist + " = " + (count < dist ? "No permutation" : answer));
        }
    }

    static void perm(int cnt) {
        if(cnt == strArr.length) {
            if (++count == dist) answer = sb.toString();
            return;
        }

        for(int i = 0; i < strArr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(strArr[i]);
                perm(cnt + 1);
                visited[i] = false;
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
