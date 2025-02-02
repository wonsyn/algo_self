import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String ans = "";
        switch (str) {
            case "SONGDO":
                ans = "HIGHSCHOOL";
                break;
            case "CODE":
                ans = "MASTER";
                break;
            case "2023":
                ans = "0611";
                break;
            case "ALGORITHM":
                ans = "CONTEST";
                break;
        }

        System.out.println(ans);
        br.close();
    }
}