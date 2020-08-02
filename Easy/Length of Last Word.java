class Solution {
    public int lengthOfLastWord(String s) {
        String[] myArray = s.trim().split(" ");
        String myString = myArray[myArray.length - 1];
        return myString.length();
    }
}