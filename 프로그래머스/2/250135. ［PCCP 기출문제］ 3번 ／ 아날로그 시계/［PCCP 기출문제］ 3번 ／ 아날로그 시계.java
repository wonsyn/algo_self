class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        
        int stCnt = start * 59 / 3600 + start * 719 / 43200;
        int edCnt = end * 59 / 3600 + end * 719 / 43200;
        
        if(start >= 43200) stCnt -= 2;
        else stCnt--;
        
        if(end >= 43200) edCnt -= 2;
        else edCnt--;
        
        if(start == 43200 || start == 0) return edCnt - stCnt + 1;
        else return edCnt - stCnt;
    }
}