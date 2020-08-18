class Solution {
    public double average(int[] salary) {
        int maxIndex = getIndexMax(salary);
        int minIndex = getIndexMin(salary);
        
        double answer = 0.0;
        for(int i = 0; i<salary.length; i++) {
            if(i == maxIndex || i == minIndex) {
                continue;
            }
            answer += salary[i];
        }
        
        answer = answer/(salary.length - 2);
        return answer;
    }
    
    private int getIndexMax(int[] salary) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i<salary.length; i++) {
            if(max < salary[i]) {
                max = salary[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    private int getIndexMin(int[] salary) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i<salary.length; i++) {
            if(min > salary[i]) {
                min = salary[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}