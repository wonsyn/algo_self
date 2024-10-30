import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] tri = new int[3];
        st = new StringTokenizer(br.readLine());
        int maxIdx = -1, max = 0;
        for(int i = 0; i < 3; i++) {
            tri[i] = Integer.parseInt(st.nextToken());
            if(tri[i] > max) {
                maxIdx = i;
                max = tri[i];
            }
        }
        int others = 0;
        for(int i = 0; i < 3; i++) {
            if(i == maxIdx) continue;
            others += tri[i];
        }

        while(others <= tri[maxIdx]) {
            tri[maxIdx]--;
        }

        System.out.println(others + tri[maxIdx]);
        br.close();
    }
}