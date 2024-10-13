import java.io.*;
import java.util.*;

public class Main {
    static int H, W, N, max = 0;
    static Paper[] paper, select = new Paper[2];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        paper = new Paper[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            paper[i] = new Paper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        comb(0, 0);

        System.out.println(max);
        br.close();
    }

    static void comb(int idx, int start) {
        if(idx == 2) {
            if(isPossible()) {
                int sum = 0;
                for(int i = 0; i < 2; i++) {
                    sum += select[i].calc();
                }
                max = Math.max(max, sum);
            }
            return;
        }

        for(int i = start; i < N; i++) {
            select[idx] = paper[i];
            comb(idx + 1, i + 1);
        }
    }

    static boolean isPossible() {
        int big = Math.max(H, W);
        int area = H * W;
        for(int i = 0; i < 2; i++) {
            if(select[i].h > big || select[i].w > big) return false;
        }

        Paper p1 = select[0];
        Paper p2 = select[1];
        if(area < p1.calc() + p2.calc()) return false;

        int h = H - p1.h;
        int w = W - p1.w;
        if((h >= 0 && w >= 0) && ((p2.h <= w && p2.w <= H) || (p2.w <= w && p2.h <= H) ||
                (p2.h <= h && p2.w <= W) || (p2.w <= h && p2.h <= W))) {
            return true;
        }

        h = H - p1.w;
        w = W - p1.h;
        if((h >= 0 && w >= 0) && ((p2.h <= w && p2.w <= H) || (p2.w <= w && p2.h <= H) ||
                (p2.h <= h && p2.w <= W) || (p2.w <= h && p2.h <= W))) {
                return true;
        }

        return false;
    }

    static class Paper {
        int h; int w;
        Paper(int h, int w) {
            this.h = h; this.w = w;
        }

        int calc() {
            return this.h * this.w;
        }
    }
}
