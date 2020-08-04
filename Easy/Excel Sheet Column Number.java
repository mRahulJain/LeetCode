class Solution {
    public int titleToNumber(String s) {
        char[] myAlphabets = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        int answer = 0;
        int iterator = 0;
        for(int i = s.length() - 1; i>=0; i--) {
            int index = getIndex(myAlphabets, s.charAt(i), 0, 25) + 1;
            answer += index*((int)Math.pow(26,iterator));
            iterator++;
        }
        return answer;
    }
    
    private int getIndex(char[] arr, char ch, int lo, int hi) {
        if(lo<=hi) {
            int mid = (lo+hi)/2;
            if(arr[mid] == ch) {
                return mid;
            } else if(arr[mid] < ch) {
                int index = getIndex(arr,ch,mid+1, hi);
                return index;
            } else {
                int index = getIndex(arr,ch,lo,mid-1);
                return index;
            }
        }
        return -1;
    }
}