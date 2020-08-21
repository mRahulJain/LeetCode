class Solution {
    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> hashmap = new TreeMap();
        
        for(int i = 0; i<arr.length; i++) {
            if(hashmap.containsKey(arr[i])) {
                hashmap.put(arr[i], hashmap.get(arr[i])+1);
            } else {
                hashmap.put(arr[i], 1);
            }
        }
        
        int answer = -1;
        Iterator iterator = hashmap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            if((int)element.getKey() == (int)element.getValue()) {
                answer = (int)element.getKey();
            }
        }
        
        return answer;
    }
}