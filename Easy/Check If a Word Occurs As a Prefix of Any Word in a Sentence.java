class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split("\\s+");
        int answer = -1;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i].startsWith(searchWord)) {
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}