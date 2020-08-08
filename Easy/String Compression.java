class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) {
            return 1;
        }
        int count = 1;
        List<Character> list = new ArrayList();
        for(int i = 0; i<chars.length; i++) {
            if(i != chars.length - 1) {
                if(chars[i] != chars[i+1]) {
                    list.add(chars[i]);
                    if(count != 1) {
                        char[] arr = String.valueOf(count).toCharArray();
                        for(int k = 0; k<arr.length; k++) {
                            list.add(arr[k]);
                        }
                    }
                    count = 1;
                } else {
                    count++;
                }
            } else {
                list.add(chars[i]);
                if(count != 1) {
                    char[] arr = String.valueOf(count).toCharArray();
                    for(int k = 0; k<arr.length; k++) {
                        list.add(arr[k]);
                    }
                }
            }
        }
        for(int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        return list.size();
    }
}