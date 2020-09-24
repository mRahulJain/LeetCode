class Solution {
    public boolean checkPossibility(int[] arr) {
        int count = 0;
        for(int i = 0; i<arr.length-1; i++) {
            if(arr[i]>arr[i+1]) {
                if(i>0) {
                    if(arr[i-1] <= arr[i+1]) {
                        arr[i] =  arr[i-1];
                    } else {
                        arr[i+1] = arr[i];
                    }
                }
                count++;
                if(count>1) {
                    return false;
                }
            }
        }
        return true;
    }
}