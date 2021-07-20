class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int i = 0; i<arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }
        
        int[] output = new int[arr1.length];
        int it = 0;
        for(int i = 0; i<arr2.length; i++) {
            int val = map.getOrDefault(arr2[i], 0);
            if(val>0) {
                map.remove(arr2[i]);
            }
            while(val>0) {
                output[it] = arr2[i];
                it++;
                val--;
            }
        }
        
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            int val = (int) element.getValue();
            int key = (int) element.getKey();
            
            while(val>0) {
                output[it] = key;
                it++;
                val--;
            }
        }
        
        return output;
    }
}