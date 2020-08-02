class Solution {
    public boolean isPalindrome(int x) {
        String actual = Integer.toString(x);
        String reversed = reverseString(actual);
        if(actual.equals(reversed)) {
            return true;
        }
        return false;
    }
    
    public static String reverseString(String str) {
        char[] arr = new char[str.length()];
        int j = 0;
        for(int i = str.length() - 1; i>=0; i--) {
            arr[j] = str.charAt(i);
            j++;
        }
        String s = new String(arr);
        return s;
    }
}