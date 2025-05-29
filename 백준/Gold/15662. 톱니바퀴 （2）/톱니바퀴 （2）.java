import java.util.*;
import java.io.*;

public class Main {
    static int T, K;
    static boolean[][] wheels;
    static boolean[][] pre;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        wheels = new boolean[T + 1][8];
        pre = new boolean[T + 1][2];

        for(int t = 1; t <= T; t++) {
            String str = br.readLine();
            for(int i = 0; i < 8; i++) {
                if(str.charAt(i) == '1') {
                    wheels[t][i] = true;
                }
            }
        }

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            rotate(select, dir);
        }
        int cnt = 0;
        for(int i = 1; i <= T; i++) {
            if(wheels[i][0]) cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
    static void rotate(int select, int dir) {
        preCopy();

        if(dir == -1)  nRotate(select);
        else pRotate(select);
        int temp = dir;

        for(int i = select; i > 0; i--) {
            if(i != 1) {
                if(pre[i][1] == pre[i - 1][0]) {
                    break;
                }
                if(temp == -1) {
                    temp = 1;
                    pRotate(i - 1);
                } else {
                    temp = -1;
                    nRotate(i - 1);
                }
            }
        }
        temp = dir;
        for(int i = select; i <= T; i++) {
            if(i != T) {
                if(pre[i][0] == pre[i + 1][1]) {
                    break;
                }
                if(temp == -1) {
                    temp = 1;
                    pRotate(i + 1);
                } else {
                    temp = -1;
                    nRotate(i + 1);
                }
            }
        }
    }

    static void pRotate(int select) {
        boolean temp = wheels[select][7];

        for(int i = 7; i > 0; i--) {
            wheels[select][i] = wheels[select][i - 1];
        }
        wheels[select][0] = temp;
    }

    static void nRotate(int select) {
        boolean temp = wheels[select][0];

        for(int i = 0; i < 7; i++) {
            wheels[select][i] = wheels[select][i + 1];
        }
        wheels[select][7] = temp;
    }

    static void preCopy() {
        for(int i = 1; i < T + 1; i++) {
            pre[i][0] = wheels[i][2];
            pre[i][1] = wheels[i][6];
        }
    }
}
