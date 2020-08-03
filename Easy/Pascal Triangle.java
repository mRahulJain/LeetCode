class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> myList = new ArrayList<>();
        int iterator = 0;
        while(iterator < numRows) {
            List<Integer> tempList = new ArrayList<>();
            int i = 0;
            while(i<=iterator) {
                if(i == 0 || i == iterator) {
                    tempList.add(1);
                } else {
                    tempList.add(myList.get(iterator-1).get(i) + myList.get(iterator-1).get(i-1));   
                }
                i++;
            }
            myList.add(tempList);
            iterator++;
        }
        return myList;
    }
}