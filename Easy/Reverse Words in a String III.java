class Solution {
    public String reverseWords(String s) {
        String[] array = s.split("\\s+");
        String result = "";
        
        for(int i = 0; i<array.length; i++) {
            StringBuilder input = new StringBuilder();
            input.append(array[i]);
            input = input.reverse();
            if(i == array.length - 1) {
                result += input.toString();
            } else {
                result += input.toString() + " ";
            }
        }
        return result;
    }
}