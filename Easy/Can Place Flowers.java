class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int countOdd = 0;
        int countEven = 0;
        
        for(int i = 0; i<flowerbed.length; i = i+2) {
            if(flowerbed[i] == 0) {
                if(i == 0) {
                    if(flowerbed.length == 1) {
                        countOdd++;
                    } else {
                        if(flowerbed[1] == 0) {
                            countOdd++;
                        }
                    }
                    continue;
                }

                if(i == flowerbed.length - 1) {
                    if(flowerbed[i-1] == 0) {
                        countOdd++;
                    }
                    continue;
                }
                
                if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    countOdd++;
                }
            }
        }
        
        for(int i = 1; i<flowerbed.length; i = i+2) {
            if(flowerbed[i] == 0) {
                if(i == 0) {
                    if(flowerbed.length == 1) {
                        countEven++;
                    } else {
                        if(flowerbed[1] == 0) {
                            countEven++;
                        }
                    }
                    continue;
                }

                if(i == flowerbed.length - 1) {
                    if(flowerbed[i-1] == 0) {
                        countEven++;
                    }
                    continue;
                }
                
                if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    countEven++;
                }
            }
        }
        
        if(countEven>=n) {
            return true;
        }
        if(countOdd>=n) {
            return true;
        }
        
        return false;
    }
}