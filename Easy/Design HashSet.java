class MyHashSet {

    HashMap hashmap;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.hashmap = new HashMap<Integer,Integer>();
    }
    
    public void add(int key) {
        if(!(this.hashmap.containsKey(key))) {
            this.hashmap.put(key, 1);
        }
    }
    
    public void remove(int key) {
        if(this.hashmap.containsKey(key)) {
            this.hashmap.remove(key);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(this.hashmap.containsKey(key)) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */