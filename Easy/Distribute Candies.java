class Solution {
    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> hashmap = new HashMap();
        for(int i = 0; i<candies.length; i++) {
            if(hashmap.containsKey(candies[i])) {
                //do nothing
            } else {
                hashmap.put(candies[i], 1);
            }
        }
        
        int typeOfCandies = hashmap.size();
        int candiesSisterGets = candies.length/2;
        
        if(typeOfCandies >= candiesSisterGets) {
            return candiesSisterGets;
        }
        
        return typeOfCandies;
    }
}