class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mapT = new HashMap();
        for(int i = 0; i<t.length(); i++) {
            int count = mapT.getOrDefault(t.charAt(i), 0);
            mapT.put(t.charAt(i), count+1);
        }
        
        int required = mapT.size();
        int l = 0;
        int r = 0;
        int formed = 0;
        
        HashMap<Character,Integer> mapS = new HashMap();
        int[] ans = {-1,0,0};
        
        while(r < s.length()) {
            char ch = s.charAt(r);
            int count = mapS.getOrDefault(ch, 0);
            mapS.put(ch, count+1);
            if(mapT.containsKey(ch) && mapT.get(ch).intValue() == mapS.get(ch).intValue()) {
                formed++;
            }
            
            while(l<=r && formed == required) {
                char c = s.charAt(l);
                if(ans[0] == -1 || r-l+1 < ans[0]) {
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                mapS.put(c, mapS.get(c)-1);
                if(mapT.containsKey(c) && mapT.get(c).intValue() > mapS.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        
        if(ans[0] == -1) {
            return "";
        }
        return s.substring(ans[1], ans[2]+1);
    }
}