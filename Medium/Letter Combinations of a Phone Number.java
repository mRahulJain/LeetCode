class Solution {
    List<String> list;
    public List<String> letterCombinations(String digits) {
        String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list = new ArrayList();
        backtrack(digits, "", 0, arr, 0);
        return list;
    }
    
    private void backtrack(String digits, String curr_answer, int curr_position, String[] arr, int arr_position) {
        if(digits.length() == curr_position) {
            if(!curr_answer.equals("")) {
                list.add(curr_answer);   
            }
            return;
        }
        
        int n = Character.getNumericValue(digits.charAt(curr_position));
        String s = arr[n];
        for(int i = 0; i<s.length(); i++) {
            backtrack(digits, curr_answer+s.charAt(i), curr_position+1, arr, arr_position+i);
        }
    }
}