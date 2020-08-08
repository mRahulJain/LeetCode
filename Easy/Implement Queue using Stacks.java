class MyQueue {

    Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<Integer>();
        tempStack.add(x);
        
        for(Integer item: this.stack) {
            tempStack.add(item);
        }
        
        this.stack = tempStack;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Integer intObject = this.stack.pop();
        return intObject.intValue();
    }
    
    /** Get the front element. */
    public int peek() {
        return (this.stack.peek()).intValue();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */