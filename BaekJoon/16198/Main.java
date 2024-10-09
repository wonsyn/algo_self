package bj_16198_에너지모으기;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long max = Long.MIN_VALUE;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_16198_에너지모으기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        perm(0, 0L);
        System.out.println(max);
        br.close();
    }

    static void perm(int cnt, long energy) {
        if(list.size() == 2) {
            max = Math.max(max, energy);
            return;
        }

        for(int i = 1; i < list.size() - 1; i++) {
            int temp = list.remove(i);
            perm(cnt + 1, energy + (long) list.get(i - 1) * list.get(i));
            list.add(i, temp);
        }
    }
}
