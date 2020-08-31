class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] answer = new int[k];
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap();
        for(int i = 0; i<mat.length; i++) {
            int count = 0;
            for(int j = 0; j<mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    count++;
                }
            }
            if(map.containsKey(count)) {
                ArrayList<Integer> list = map.get(count);
                list.add(i);
                map.put(count,list);
            } else {
                ArrayList<Integer> list = new ArrayList();
                list.add(i);
                map.put(count,list);
            }
        }
        int index = 0;
        Iterator iterator = map.entrySet().iterator();
        boolean done = false;
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            ArrayList<Integer> list = (ArrayList<Integer>) element.getValue();
            for(int i = 0; i<list.size(); i++) {
                answer[index] = list.get(i);
                index++;
                if(index == k) {
                    done = true;
                    break;
                }
            }
            if(done) {
                break;
            }
        }
        return answer;
    }
}