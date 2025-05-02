
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans = Integer.MAX_VALUE;
    static boolean[] ck;
    static List<int[]> home, chicken;

    public static void main(String[] args)  throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++)
                switch (Integer.parseInt(st.nextToken())) {
                    case 1:
                        home.add(new int[]{i, j});
                        break;
                    case 2:
                        chicken.add(new int[]{i, j});
                        break;
                }
        }
        ck = new boolean[chicken.size()];
        subSet(-1, 0);

        System.out.println(ans);
        
        br.close();
    }

    static void subSet(int idx, int cnt) {
        if (cnt == M) {
            int dist = 0;

            for (int[] h : home) {
                int tmp = Integer.MAX_VALUE;
                for (int i = 0; i < ck.length; i++) {
                    if (ck[i])
                        tmp = Math.min(tmp, Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]));
                }
                dist += tmp;
            }
            ans = Math.min(ans, dist);
            return;
        }

        for (int i = idx + 1; i < ck.length; i++) {
            ck[i] = true;
            subSet(i, cnt + 1);
            ck[i] = false;
        }
    }
}
