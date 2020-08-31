class Solution {
    public boolean containsPattern(int[] arr, int m, int kk) {
        
        for(int i = 0; i<=(arr.length-(m*kk)); i++) {
            int count = 0;
            int[] myArray = new int[m];
            boolean flag = false;
            for(int j = i; j<arr.length; j=j+m) {
                if(j==i) {
                    for(int k = 0; k<m; k++) {
                        myArray[k] = arr[k+j];
                    }
                    count++;
                } else {
                    for(int k = 0; k<m; k++) {
                        if(myArray[k] != arr[k+j]) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag) {
                        break;
                    } else {
                        count++;
                        if(count == kk) {
                            return true;
                        }
                    }
                }
            }    
        }
        
        return false;
    }
}