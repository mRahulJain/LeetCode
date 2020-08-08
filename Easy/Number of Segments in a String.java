class Solution {
    public int countSegments(String s) {
        s = s.trim();
        if(s.equals("")) {
            return 0;
        }
        String[] list = s.split("\\s+");
        for(int i = 0; i<list.length; i++) {
            System.out.println(list[i]);
        }
        return list.length;
    }
}