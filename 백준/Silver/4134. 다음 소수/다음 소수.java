import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());

            if(num == 0 || num == 1) {
                sb.append(2).append("\n");
                continue;
            }

            while(true) {
                boolean flag = false;
                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    sb.append(num).append("\n");
                    break;
                } else {
                    num++;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}