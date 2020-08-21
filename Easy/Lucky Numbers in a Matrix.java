class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        HashMap<Integer, Integer> hashmap = new HashMap();
        
        for(int i = 0; i<matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    index = j;
                }
            }
            if(hashmap.containsKey(index)) {
                if(hashmap.get(index).intValue() < min) {
                    hashmap.put(index, min);
                }
            } else {
                hashmap.put(index, min);
            }
        }   
        
        List<Integer> list = new ArrayList();
        
        for(int i = 0; i<matrix[0].length; i++) {
            if(!hashmap.containsKey(i)) {
                continue;
            }
            int max = Integer.MIN_VALUE;
            for(int j = 0; j<matrix.length; j++) {
                if(matrix[j][i] > max) {
                    max = matrix[j][i];
                }
            }
            if(max == hashmap.get(i).intValue()) {
                list.add(max);
            }
        }
        
        return list;
    }
}