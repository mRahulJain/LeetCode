class Solution {
    public String restoreString(String s, int[] indices) {
        char[] myArray = new char[s.length()];
        
        for(int i = 0; i<indices.length; i++) {
            myArray[indices[i]] = s.charAt(i);
        }
        
        String str = new String(myArray);
        
        return str;
    }
}