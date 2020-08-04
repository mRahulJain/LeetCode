class MinStack {
    
    int[] myArray;
    int top;
    /** initialize your data structure here. */
    public MinStack() {
        this.myArray = new int[1];
        this.top = -1;
    }
    
    public void push(int x) {
        if(this.top == this.myArray.length - 1) {
            int[] tempArray = new int[this.myArray.length * 2];
            for(int i = 0; i<this.myArray.length; i++) {
                tempArray[i] = this.myArray[i];
            }
            this.myArray = tempArray;
        }
        this.top++;
        this.myArray[top] = x;
    }
    
    public void pop() {
        this.myArray[top] = 0;
        this.top--;
    }
    
    public int top() {
        return this.myArray[top];
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<=this.top; i++) {
            if(this.myArray[i] < min) {
                min = this.myArray[i];
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */