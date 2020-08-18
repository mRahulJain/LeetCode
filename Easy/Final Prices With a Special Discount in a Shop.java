class Solution {
    public int[] finalPrices(int[] prices) {
        for(int i = 0; i<prices.length-1; i++) {
            int j = i+1;
            int discount = 0;
            while(j<prices.length) {
                if(prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
                j++;
            }
            prices[i] = prices[i] - discount;
        }
        return prices;
    }
}