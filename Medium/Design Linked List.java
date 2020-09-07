class MyLinkedList {

    int val;
    MyLinkedList next;
    MyLinkedList head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int i = 0;
        MyLinkedList temp = this.head;
        while(temp!=null) {
            if(i == index) {
                return temp.val;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        node.next = this.head;
        this.head = node;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        node.next = null;
        MyLinkedList temp = this.head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
        } else {
            MyLinkedList node = new MyLinkedList();
            node.val = val;
            MyLinkedList temp = this.head;
            int i = 0;
            while(i<index-1) {
                i++;
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0) {
            MyLinkedList temp = this.head.next;
            this.head.next = null;
            this.head = temp;
        } else {
            MyLinkedList temp = this.head;
            int i = 0;
            while(i<index-1) {
                i++;
                temp = temp.next;
            }
            if(temp.next != null) {
                temp.next = temp.next.next;
            }   
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */