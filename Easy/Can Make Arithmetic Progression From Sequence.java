class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap();
        
        for(int i = 0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                if(map.size() != 1) {
                    return false;   
                }
            }
            map.put(arr[i], 1);
        }
        
        Iterator iterator = map.entrySet().iterator();
        int i = 0;
        int prev = 0;
        int diff = 0;
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            if(i == 0) {
                prev = (int) element.getKey();
            } else if(i == 1) {
                diff = (int) element.getKey() - prev;
                prev = (int) element.getKey();
            } else {
                if(diff != (int) element.getKey() - prev) {
                    return false;
                }
                prev = (int) element.getKey();
            }
            i++;
        }
        return true;
    }
}