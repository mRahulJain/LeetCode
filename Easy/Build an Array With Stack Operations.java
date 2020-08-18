class Solution {
    public List<String> buildArray(int[] target, int n) {
        int toPush = 1;
        List<String> list = new ArrayList();
        int i = 0;
        while(i<target.length) {
            if(target[i] == toPush) {
                list.add("Push");
                i++;
                toPush++;
            } else {
                list.add("Push");
                list.add("Pop");
                toPush++;
            }
        }
        return list;
    }
}