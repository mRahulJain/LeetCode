class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList();
        runBacktrack("", 0, 0, n);
        return list;
    }
    
    private void runBacktrack(String str, int open, int close, int max) {
        if(str.length() == max*2) {
            list.add(str);
            return;
        }
        
        if(open<max) {
            runBacktrack(str+"(", open+1, close, max);
        }
        
        if(open>close) {
            runBacktrack(str+")", open, close+1, max);
        }
    }
}