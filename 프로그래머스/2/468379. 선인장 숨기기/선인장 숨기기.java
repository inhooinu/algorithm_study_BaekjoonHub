import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        
        int[][] firstDropTime = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                firstDropTime[i][j] = drops.length+1;
            }
        }
        for (int i=0; i<drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            firstDropTime[r][c] = i+1;
        }
        // for (int i=0; i<firstDropTime.length; i++) {
        //     System.out.println(Arrays.toString(firstDropTime[i]));
        // }
        
        int maxTime = 0;
        int[] answer = new int[2];
        for (int i=0; i<m-h+1; i++) {
            for (int j=0; j<n-w+1; j++) {
                int time = checkTime(i,j,h,w, firstDropTime);
                if (time>maxTime) {
                    // System.out.println(time);
                    maxTime = time;
                    answer[0] = i;
                    answer[1] = j;
                }
                if (time==drops.length+1) return answer;
            }
        }
        
        return answer;
    }
    
    public int checkTime(int r, int c, int h, int w, int[][] firstDropTime) {
        int time = Integer.MAX_VALUE;
        for (int i=r; i<r+h; i++) {
            for (int j=c; j<c+w; j++) {
                time = Math.min(time, firstDropTime[i][j]);
            }
        }
        
        return time;
    }
}