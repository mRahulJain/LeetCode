class Solution {
    public boolean checkIfExist(int[] arr) {
        TreeMap<Integer,Integer> map = new TreeMap();
        for(int i = 0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
        }
        
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            int key = (int) element.getKey();
            int value = (int) element.getValue();
            if(map.containsKey(key*2)) {
                if(key*2 == key) {
                    if(value>1) {
                        return true;
                    }
                } else {
                    return true;   
                }
            }
        }
        return false;
    }
}