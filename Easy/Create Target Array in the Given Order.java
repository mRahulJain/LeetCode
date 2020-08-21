class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i<nums.length; i++) {
            list.add(0);
        }
        for(int i = 0; i<nums.length; i++) {
            list.add(index[i],nums[i]);
        }
        int[] myAnswer = new int[nums.length];
        for(int i = 0; i<myAnswer.length; i++) {
            myAnswer[i] = list.get(i);
        }
        return myAnswer;
    }
}