class Solution {
    public int countLargestGroup(int n) {
        List<Integer> list = new ArrayList();
        int num= 1;
        while(num<=n) {
            int sum = 0;
            int temp = num;
            while(temp>0) {
                int rem = temp%10;
                sum += rem;
                temp = temp/10;
            }
            if(list.size() < sum) {
                list.add(1);
            } else {
                list.set(sum-1, list.get(sum-1)+1);
            }
            num++;
        }
        
        int max = Integer.MIN_VALUE;
        int answer = 0;
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i)>max) {
                max = list.get(i);
                answer = 1;
            } else if(list.get(i) == max){
                answer++;
            }
        }
        
        return answer;
    }
}