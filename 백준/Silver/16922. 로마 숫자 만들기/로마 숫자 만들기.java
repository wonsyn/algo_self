import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] numbers = {1, 5, 10, 50};
    static int[] selected;
    static Set<Integer> set;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        selected = new int[N];
        select(0, 0);

        System.out.println(set.size());
        br.close();
    }

    static void select(int idx, int start) {
        if(idx == N) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                sum += selected[i];
            }
            set.add(sum);
            return;
        }

        for(int i = start; i < 4; i++) {
            selected[idx] = numbers[i];
            select(idx + 1, i);
        }
    }
}
