class NumArray {

    int[] myArray;
    public NumArray(int[] nums) {
        this.myArray = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for(int start = i; start<=j; start++) {
            sum += this.myArray[start];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */