class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int i = 0;
        int number = 1;
        int answer = 0;
        while(count<k && i<arr.length) {
            if(number < arr[i]) {
                answer = number;
                number++;
                count++;
            } else if(number == arr[i]) {
                i++;
                number++;
            }
        }
        
        while(count<k) {
            answer = number;
            number++;
            count++;
        }
        return answer;
    }
}