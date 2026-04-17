import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Integer[] sortedCitations = new Integer[citations.length];
        for (int i=0; i<citations.length; i++) {
            sortedCitations[i] = citations[i];
        }
        Arrays.sort(sortedCitations, (a,b)->Integer.compare(b,a));
        System.out.println(Arrays.toString(sortedCitations));
        
        for (int i=0; i<sortedCitations.length; i++) {
            int paperCnt = i+1;
            int citation = sortedCitations[i];
            
            if (paperCnt>citation) return paperCnt-1;
        }
        
        return citations.length;
    }
}