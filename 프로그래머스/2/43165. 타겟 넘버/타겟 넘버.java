class Solution {
    
    static int l;
    static int t;
    static int result;
    
    public int solution(int[] numbers, int target) {
        l = numbers.length;
        t = target;
        result = 0;
        calc(numbers, 0, 0);
        
        return result;
    }
    
    public void calc(int[] numbers, int i, int v) {
        if (i==l) {
            if (v==t) result++;
            return;
        }
        
        int temp = v + numbers[i];
        calc(numbers, i+1, temp);
        
        temp = v - numbers[i];
        calc(numbers, i+1, temp);
    }
}