class Solution {
    public int solution(int[][] sizes) {
        
        int maxW = 0;
        int maxH = 0;
        
        for (int i=0; i<sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            if (w<h) {  // 명함 돌리기
                maxW = Math.max(maxW, h);
                maxH = Math.max(maxH, w);
            } else {
                maxW = Math.max(maxW, w);
                maxH = Math.max(maxH, h);
            }
        }
        
        int answer = maxW * maxH;
        return answer;
    }
}