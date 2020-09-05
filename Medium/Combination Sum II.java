class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list = new ArrayList();
        List<Integer> temp = new ArrayList();
        List<Integer> temp2 = new ArrayList();
        backtrack(candidates, temp, temp2, 0, target);
        return list;
    }
    
    private void backtrack(int[] candidates, List<Integer> temp, List<Integer> temp2, int currentSum,  int target) {
        if(currentSum == target) {
            List<Integer> done = new ArrayList(temp);
            Collections.sort(done);
            if(!list.contains(done)) {
                list.add(done);   
            }
            
            temp.remove(temp.size()-1);
            temp2.remove(temp2.size()-1);
            return;
        }
        
        if(currentSum>target) {
            temp.remove(temp.size()-1);
            temp2.remove(temp2.size()-1);
            return;
        }
        
        for(int i = 0; i<candidates.length; i++) {
            if(temp2.contains(i)) {
               continue; 
            }
            temp.add(candidates[i]);
            temp2.add(i);
            backtrack(candidates, temp, temp2, currentSum+candidates[i], target);
        }
        if(temp.size()!=0) {
            temp.remove(temp.size()-1);
            temp2.remove(temp2.size()-1);
        }
    }
}