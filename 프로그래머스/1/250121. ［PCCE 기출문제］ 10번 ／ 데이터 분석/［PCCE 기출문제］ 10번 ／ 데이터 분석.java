import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        final int compare;
        if(ext.equals("code")) {
            compare = 0;
        } else if(ext.equals("date")) {
            compare = 1;
        } else if(ext.equals("maximum")) {
            compare = 2;
        } else {
            compare = 3;
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] d : data) {
            if(d[compare] < val_ext) {
                list.add(d);
            }
        }
        
        final int comp;
        if(sort_by.equals("code")) {
            comp = 0;
        } else if(sort_by.equals("date")) {
            comp = 1;
        } else if(sort_by.equals("maximum")) {
            comp = 2;
        } else {
            comp = 3;
        }
        
        list.sort((o1, o2) -> o1[comp] - o2[comp]);
        
        answer = new int[list.size()][];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}