class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i<rounds.length-1; i++) {
            int start = rounds[i];
            int end = rounds[i+1];
            
            while(start!=end) {
                if(map.containsKey(start)) {
                    map.put(start, map.get(start)+1);
                } else {
                    map.put(start,1);
                }
                start++;
                if(start>n) {
                    start = 1;
                }
            }
        }
        if(map.containsKey(rounds[rounds.length-1])) {
            map.put(rounds[rounds.length-1],map.get(rounds[rounds.length-1])+1);
        } else {
            map.put(rounds[rounds.length-1],1);
        }
        
        int max = Integer.MIN_VALUE;
        List<Integer> answer = new ArrayList();
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            int value = (int) element.getValue();
            int key = (int) element.getKey();
            
            if(value>max) {
                max = value;
                answer.clear();
                answer.add(key);
            } else if(value == max) {
                answer.add(key);
            }
        }
        Collections.sort(answer);
        return answer;
    }
}