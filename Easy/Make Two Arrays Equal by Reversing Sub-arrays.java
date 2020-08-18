class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map1 = new HashMap();
        HashMap<Integer, Integer> map2 = new HashMap();
        
        for(int i = 0; i<target.length; i++) {
            if(map1.containsKey(target[i])) {
                map1.put(target[i], map1.get(target[i])+1);
            } else {
                map1.put(target[i],1);
            }
        }
        for(int i = 0; i<arr.length; i++) {
            if(map2.containsKey(arr[i])) {
                map2.put(arr[i], map2.get(arr[i])+1);
            } else {
                map2.put(arr[i],1);
            }
        }
        
        return map1.equals(map2);
    }
}