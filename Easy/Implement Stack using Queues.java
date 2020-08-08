class MyStack {

    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Queue tempQueue = new LinkedList<Integer>();
        tempQueue.add(x);
        for(Integer item: this.queue) {
            tempQueue.add(item);
        }
        this.queue = tempQueue;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.queue.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return this.queue.element();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */