class Solution {
    public String reverseVowels(String s) {
        if(s.length() == 0) {
            return s;
        }
        
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        
        char[] myString = s.toCharArray();
        int start = 0;
        int end = myString.length - 1;
        
        while(start<end) {
            if(!check(vowels, myString[start])) {
                start++;
                continue;
            }
            if(!check(vowels, myString[end])) {
                end--;
                continue;
            }
            
            char temp = myString[start];
            myString[start] = myString[end];
            myString[end] = temp;
            start++;
            end--;
        }
        
        String answer = new String(myString);
        return answer;
    }
    
    private boolean check(char[] arr, char toCheckValue) { 
        boolean test = false; 
        for (char element : arr) { 
            if (element == toCheckValue) { 
                test = true; 
                break; 
            } 
        }
        return test;
    } 
}