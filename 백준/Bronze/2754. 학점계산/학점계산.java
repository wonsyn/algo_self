import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String ans = "";
        switch (str) {
            case "A+":
                ans = "4.3";
                break;
            case "A0":
                ans = "4.0";
                break;
            case "A-":
                ans = "3.7";
                break;
            case "B+":
                ans = "3.3";
                break;
            case "B0":
                ans = "3.0";
                break;
            case "B-":
                ans = "2.7";
                break;
            case "C+":
                ans = "2.3";
                break;
            case "C0":
                ans = "2.0";
                break;
            case "C-":
                ans = "1.7";
                break;
            case "D+":
                ans = "1.3";
                break;
            case "D0":
                ans = "1.0";
                break;
            case "D-":
                ans = "0.7";
                break;
            case "F":
                ans = "0.0";
                break;
        }

        System.out.println(ans);
        br.close();
    }
}