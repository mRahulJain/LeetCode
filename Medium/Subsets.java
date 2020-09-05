class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        int start = 0;
        int end = (int) Math.pow(2, nums.length);
        while(start<end) {
            String s = getBinary(start, nums.length);
            List<Integer> temp = new ArrayList();
            for(int i = 0; i<s.length(); i++) {
                if(s.charAt(i) == '1') {
                    temp.add(nums[i]);
                }
            }
            list.add(temp);
            start++;
        }
        return list;
    }
    
    private String getBinary(int n, int k) {
        String toReturn = "";
        while(n!=0) {
            int rem = n%2;
            toReturn = rem + toReturn;
            n = n/2;
        }
        
        while(toReturn.length() < k) {
            toReturn = "0"+toReturn;
        }
        System.out.println(toReturn);
        return toReturn;
    }
}