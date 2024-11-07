import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int cnt, ans, K;
    static int[] tmp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        tmp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        ans = -1;
        merge_sort(arr, 0, arr.length - 1);
        System.out.println(ans);
        br.close();
    }

    static void merge_sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(A, p, q);
            merge_sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    static void merge(int[] A, int p, int q, int r) {
        int i = p; int j = q + 1; int t = 0;
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }
        while (i <= q){
            tmp[t++] = A[i++];
        }
        while (j <= r){
            tmp[t++] = A[j++];
        }
        i = p;
        t = 0;
        while (i <= r){
            cnt++;
            if(cnt == K) {
                ans = tmp[t];
            }
            A[i++] = tmp[t++];
        }
    }
}