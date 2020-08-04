class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i<prices.length; i++) {
            for(int j = i+1; j<prices.length; j++) {
                if(answer < prices[j]-prices[i]) {
                    answer = prices[j]-prices[i];
                }
            }
        }
        if(answer < 0) {
            return 0;
        }
        return answer;
    }
}