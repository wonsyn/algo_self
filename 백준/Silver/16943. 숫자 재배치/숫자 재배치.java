import java.io.*;
import java.util.*;

public class Main {
    static char[] A;
    static int B, max = -1;
    static char[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken().toCharArray();
        visited = new boolean[A.length];
        selected = new char[A.length];
        B = Integer.parseInt(st.nextToken());

        if(B / (Math.pow(10, A.length - 1)) >= 1) {
            perm(0);
        }

        System.out.println(max);
        br.close();
    }

    static void perm(int idx) {
        if(idx == A.length) {
            String str = "";
            for (int i = 0; i < idx; i++) {
                str += selected[i];
            }
            int num = Integer.parseInt(str);
            if (num < B) {
                max = Math.max(max, num);
            }
            return;
        }

        for(int i = 0; i < A.length; i++) {
            if(!visited[i]) {
                if(idx == 0 && A[i] == '0') continue;
                visited[i] = true;
                selected[idx] = A[i];
                perm(idx + 1);
                visited[i] = false;
            }
        }
    }
}
