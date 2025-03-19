import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        int[] arr = new int[N + 1];
        set.add(0);
        arr[0] = 0;
        for(int i = 1; i <= N; i++) {
            if(arr[i - 1] - i < 0 || set.contains(arr[i - 1] - i)) {
                arr[i] = arr[i - 1] + i;
                set.add(arr[i - 1] + i);
            } else {
                arr[i] = arr[i - 1] - i;
                set.add(arr[i - 1] - i);
            }
        }

        System.out.println(arr[N]);
        br.close();
    }
}