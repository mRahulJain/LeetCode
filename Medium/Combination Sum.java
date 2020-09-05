class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList();
        List<Integer> temp = new ArrayList();
        backtrack(candidates, temp, 0, target);
        return list;
    }
    
    private void backtrack(int[] candidates, List<Integer> temp, int currentSum,  int target) {
        if(currentSum == target) {
            List<Integer> done = new ArrayList(temp);
            Collections.sort(done);
            if(!list.contains(done)) {
                list.add(done);   
            }
            
            temp.remove(temp.size()-1);
            return;
        }
        
        if(currentSum>target) {
            temp.remove(temp.size()-1);
            return;
        }
        
        for(int i = 0; i<candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, temp, currentSum+candidates[i], target);
        }
        if(temp.size()!=0) {
            temp.remove(temp.size()-1);
        }
    }
}