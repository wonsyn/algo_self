import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if(min > arr[i]) {
                min = arr[i];
                minIdx = i;
            }
        }

        if(sum >= 100) {
            System.out.println("OK");
        } else {
            System.out.println(minIdx == 0 ? "Soongsil" : minIdx == 1 ? "Korea" : "Hanyang");
        }

        br.close();
    }
}