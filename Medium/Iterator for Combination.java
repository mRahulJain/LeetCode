class CombinationIterator {

    ArrayList<String> list;
    int pos;
    ArrayList<String> binaryList;
    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList();
        binaryList = new ArrayList();
        getBinaryList(characters.length(), combinationLength);
        getList(characters);
        Collections.sort(list);
        pos = 0;
    }
    
    private void getList(String str) {
        for(int i = 0; i<binaryList.size(); i++) {
            String temp = "";
            for(int j = 0; j<binaryList.get(i).length(); j++) {
                if(binaryList.get(i).charAt(j) == '1') {
                    temp = temp + str.charAt(j);
                }
            }
            list.add(temp);
        }
    }
    
    private void getBinaryList(int num, int N) {
        int i = 0;
        while(i<Math.pow(2,num)) {
            String str = getBinary(i);
            while(str.length() < num) {
                str = "0" + str;
            }
            int count = 0;
            for(int j = 0; j<str.length(); j++) {
                if(str.charAt(j) == '1') {
                    count++;
                }
            }
            i++;
            if(count == N) {
                binaryList.add(str);
            }
        }
    }
    
    private String getBinary(int num) {
        String str = "";
        
        while(num>0) {
            str = num%2 + str;
            num = num/2;
        }
        
        return str;
    }
    
    public String next() {
        if(pos < list.size()) {
            String str = list.get(pos);
            pos++;
            return str;   
        }
        return "";
    }
    
    public boolean hasNext() {
        return pos < list.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */