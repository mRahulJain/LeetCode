class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList();
        List<Integer> temp = new ArrayList();
        backtrack(temp, n, k, 1);
        return list;
    }
    
    private void backtrack(List<Integer> temp, int n, int k, int start) {
        if(temp.size() == k) {
            List<Integer> done = new ArrayList(temp);
            list.add(done);
            temp.remove(temp.size()-1);
            return;
        }
        
        while(start<=n) {
            temp.add(start);
            backtrack(temp, n, k, start+1);
            start++;
        }
        if(temp.size()!=0) {
            temp.remove(temp.size()-1);
        }
    }
}