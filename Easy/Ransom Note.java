class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mapNote = new HashMap();
        for(int i = 0; i<ransomNote.length(); i++) {
            if(mapNote.containsKey(ransomNote.charAt(i))) {
                mapNote.put(ransomNote.charAt(i), mapNote.get(ransomNote.charAt(i))+1);
            } else {
                mapNote.put(ransomNote.charAt(i), 1);
            }
        }
        
        HashMap<Character, Integer> mapMagazine = new HashMap();
        for(int i = 0; i<magazine.length(); i++) {
            if(mapMagazine.containsKey(magazine.charAt(i))) {
                mapMagazine.put(magazine.charAt(i), mapMagazine.get(magazine.charAt(i))+1);
            } else {
                mapMagazine.put(magazine.charAt(i), 1);
            }
        }
        
        Iterator iterator = mapNote.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            char key = (char) element.getKey();
            int value = (int) element.getValue();
            
            if(!mapMagazine.containsKey(key)) {
                return false;
            } else {
                if(mapMagazine.get(key) < value) {
                    return false;
                }
            }
        }
        return true;
    }
}