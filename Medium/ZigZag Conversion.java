class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) {
            return s;
        }
        
        String[] myArray = new String[numRows];
        for(int i = 0; i<numRows; i++) {
            myArray[i] = "";
        }
        
        int iterator = 0;
        boolean flag = false;
        for(int i = 0; i<s.length(); i++) {
            if(iterator == 0) {
                flag = false;
            }
            
            if(iterator == numRows - 1) {
                flag = true;
            }
            
            
            if(!flag) {
                myArray[iterator] += s.charAt(i);
                iterator++;
            } else {
                myArray[iterator] += s.charAt(i);
                iterator--;
            }
        }
        
        String answer = "";
        for(int i = 0; i<numRows; i++) {
            answer += myArray[i];
        }
        
        return answer;
    }
}