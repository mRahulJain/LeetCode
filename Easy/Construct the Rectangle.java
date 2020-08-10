class Solution {
    public int[] constructRectangle(int area) {
        if(area == 0) {
            return new int[0];
        }
        int[] answer = new int[2];
        int iterator = 1;
        while(iterator<=area) {
            int toMultiply = area/iterator;
            if(iterator*toMultiply == area && iterator >= toMultiply) {
                if(answer[0] == 0 && answer[1] == 0) {
                    answer[0] = iterator;
                    answer[1] = toMultiply;
                } else {
                    if(iterator-toMultiply < answer[0]-answer[1]) {
                        answer[0] = iterator;
                        answer[1] = toMultiply;
                    }
                }
            }
            iterator++;
        }
        return answer;
    }
}