package bj_11723_집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num;
            switch (op) {
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    if(set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all" :
                    set.clear();
                    for(int j = 1; j <= 20; j++) set.add(j);
                    break;
                case "empty" :
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}
