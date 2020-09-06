class Solution {
    int count = 0;
    String answer = "";
    public String getPermutation(int n, int k) {
        List<Integer> temp = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        backtrack(n, k, temp, map);
        return answer;
    }
    
    private void backtrack(int n, int k, List<Integer> temp, HashMap<Integer, Integer> map) {
        if(count>k) {
            return;
        }
        if(temp.size() == n) {
            count++;
            if(count == k) {
                for(Integer element: temp) {
                    answer += element;
                }   
            }
            return;
        }
        int i = 1;
        while(i<=n) {
            if(count>k) {
                return;
            }
            if(!map.containsKey(i)) {
                temp.add(i);
                map.put(i,1);
                backtrack(n, k, temp, map);
                temp.remove(temp.size()-1);
                map.remove(i);
            }
            i++;
        }
    }
}