class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = getMax(candies);
        List<Boolean> list = new ArrayList();
        
        for(int i = 0; i<candies.length; i++) {
            if(candies[i]+extraCandies >= max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
    
    private int getMax(int[] candies) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<candies.length; i++) {
            if(candies[i] > max) {
                max = candies[i];
            }
        }
        return max;
    }
}