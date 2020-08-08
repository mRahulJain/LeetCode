class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] myArray = new int[nums.length];
        for(int i = 0; i<nums.length; i++) {
            myArray[nums[i] - 1] = 1;
        }
        
        List<Integer> answer = new ArrayList();
        for(int i = 0; i<myArray.length; i++) {
            if(myArray[i] == 0) {
                answer.add(i+1);
            }
        }
        return answer;
    }
}