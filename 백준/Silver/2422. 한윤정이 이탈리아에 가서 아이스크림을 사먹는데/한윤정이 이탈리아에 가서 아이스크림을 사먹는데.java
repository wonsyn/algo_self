import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans;
    static Set<Integer>[] imp;
    static int[] selected = new int[3];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        imp = new HashSet[N + 1];
        for(int i = 1; i <= N; i++) {
            imp[i] = new HashSet<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            imp[a].add(b);
            imp[b].add(a);
        }

        select(0, 1);

        System.out.println(ans);
        br.close();

    }

    static void select(int idx, int start) {
        if(idx == 3) {
            for(int i = 0; i < 2; i++) {
                for(int j = i + 1; j < 3; j++) {
                    if(imp[selected[i]].contains(selected[j])) {
                        return;
                    }
                }
            }
            ans++;
            return;
        }

        for(int i = start; i <= N; i++) {
            selected[idx] = i;
            select(idx + 1, i + 1);
        }
    }
}
