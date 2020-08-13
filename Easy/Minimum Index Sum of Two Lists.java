class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hashmap = new HashMap();
        
        for(int i = 0; i<list1.length; i++) {
            hashmap.put(list1[i], i);
        }
        
        int leastNumber = Integer.MAX_VALUE;
        ArrayList<String> list = new ArrayList();
        for(int i = 0; i<list2.length; i++) {
            if(hashmap.containsKey(list2[i])) {
                int value = hashmap.get(list2[i]).intValue();
                if(i+value<leastNumber) {
                    list.clear();
                    list.add(list2[i]);
                    leastNumber = i+value;
                } else if(i+value == leastNumber) {
                    list.add(list2[i]);
                }
            }
        }
        
        return getArray(list);
    }
    
    private String[] getArray(ArrayList<String> list) {
        String[] arr = new String[list.size()];
        for(int i = 0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}