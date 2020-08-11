class Solution {
    public String reverseStr(String s, int k) {
        char[] myArray = s.toCharArray();
        int last = k-1;
        int start = 0;
        int iterator = 2;
        while(start<=last && last<s.length()) {
            char temp = myArray[start];
            myArray[start] = myArray[last];
            myArray[last] = temp;
            last--;
            start++;
            if(last<=start) {
                start = iterator*k;
                last = (iterator*k)+k-1;
                iterator = iterator + 2;
            }
        }
        
        if(start < s.length()) {
            last = s.length() - 1;
            while(start<=last) {
                char temp = myArray[start];
                myArray[start] = myArray[last];
                myArray[last] = temp;
                last--;
                start++;
            }
        }
        
        return new String(myArray);
    }
}