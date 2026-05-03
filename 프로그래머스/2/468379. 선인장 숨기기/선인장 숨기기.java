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
        // System.out.println();
        
        // 1. 각 행마다 w구간 최솟값 구하기
        int[][] rowMin = new int[m][n-w+1];
        for (int r=0; r<m; r++) {
            Deque<Integer> dq = new ArrayDeque<>();
            
            for (int c=0; c<n; c++) {
                while (!dq.isEmpty() && firstDropTime[r][dq.peekLast()] >= firstDropTime[r][c]) {
                    dq.pollLast();
                }
                
                dq.offerLast(c);
                
                if (dq.peekFirst() <= c-w) {  // w구간을 벗어난 경우 poll
                    dq.pollFirst();
                }
                
                if (c >= w-1) {
                    rowMin[r][c-w+1] = firstDropTime[r][dq.peekFirst()];
                }
            }
        }
        // for (int r=0; r<m; r++) {
        //     System.out.println(Arrays.toString(rowMin[r]));
        // }
        // System.out.println();
        
        // 2. 각 열마다 h구간 최솟값 구하기
        int maxTime = 0;
        int[] answer = new int[2];
        for (int c=0; c<n-w+1; c++) {
            Deque<Integer> dq = new ArrayDeque<>();
            
            for (int r=0; r<m; r++) {
                while (!dq.isEmpty() && rowMin[dq.peekLast()][c] >= rowMin[r][c]) {
                    dq.pollLast();
                }
                
                dq.offerLast(r);
                
                if (dq.peekFirst() <= r-h) {
                    dq.pollFirst();
                }
                
                if (r >= h-1) {
                    int startR = r-h+1;
                    int startC = c;
                    
                    int time = rowMin[dq.peekFirst()][c];
                    
                    if (time > maxTime) {
                        maxTime = time;
                        answer[0] = startR;
                        answer[1] = startC;
                    } else if (time==maxTime && answer[0] > startR) {
                        answer[0] = startR;
                        answer[1] = startC;
                    }
                }
            }
        }
        
        return answer;
    }
}