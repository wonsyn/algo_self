class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int L = 0;
        int R = sequence.length - 1;
        int left = 0;
        int right = 1;
        int sum = sequence[0];
        
        while(left < right) {
            if(sum == k) {
                if(R - L > right - left - 1) {
                    R = right - 1;
                    L = left;
                }
                sum -= sequence[left++];
                if(right + 1 <= sequence.length) {
                    sum += sequence[right++];
                }
            } else if(sum > k) {
                sum -= sequence[left++];
            } else if(right < sequence.length) {
                sum += sequence[right++];
            } else {
                break;
            }
        }

        answer[0] = L;
        answer[1] = R;
        return answer;
    }
}