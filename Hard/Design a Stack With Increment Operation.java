class CustomStack {

    int[] arr;
    int myPointer;
    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
        this.myPointer = -1;
    }
    
    public void push(int x) {
        this.myPointer++;
        if(this.myPointer < this.arr.length) {
            this.arr[this.myPointer] = x;
        } else {
            this.myPointer--;
        }
    }
    
    public int pop() {
        if(this.myPointer == -1) {
            return -1;
        }
        int toReturn = this.arr[this.myPointer];
        this.arr[this.myPointer] = 0;
        this.myPointer--;
        return toReturn;
    }
    
    public void increment(int k, int val) {
        if(k>this.arr.length) {
            for(int i = 0; i<this.arr.length; i++) {
                this.arr[i] += val;
            }
        } else {
            for(int i = 0; i<k; i++) {
                this.arr[i] += val;
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */