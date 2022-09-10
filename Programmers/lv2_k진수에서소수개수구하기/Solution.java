package programmers_lv2_k진수에서소수개수구하기;

public class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String knary = "";
        while(n != 0) {
            int mod = n % k;
            n /= k;
            knary = mod + knary;
        }

        int i, j;
        for(i = 0; i < knary.length(); i = j) {
            for(j = i + 1; j < knary.length() && knary.charAt(j) != '0'; j++);
            if(isPrime(Integer.parseInt(knary.substring(i, j)))) {
                answer++;
            }
        }

        return answer;
    }

    boolean isPrime(int n) {
        if(n <= 1) return false;
        else if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
