class Solution {
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> hashmap = new HashMap();
        
        hashmap.put('q',1);
        hashmap.put('Q',1);
        hashmap.put('w',1);
        hashmap.put('W',1);
        hashmap.put('e',1);
        hashmap.put('E',1);
        hashmap.put('r',1);
        hashmap.put('R',1);
        hashmap.put('t',1);
        hashmap.put('T',1);
        hashmap.put('y',1);
        hashmap.put('Y',1);
        hashmap.put('u',1);
        hashmap.put('U',1);
        hashmap.put('i',1);
        hashmap.put('I',1);
        hashmap.put('o',1);
        hashmap.put('O',1);
        hashmap.put('p',1);
        hashmap.put('P',1);
        
        hashmap.put('a',2);
        hashmap.put('A',2);
        hashmap.put('s',2);
        hashmap.put('S',2);
        hashmap.put('d',2);
        hashmap.put('D',2);
        hashmap.put('f',2);
        hashmap.put('F',2);
        hashmap.put('g',2);
        hashmap.put('G',2);
        hashmap.put('h',2);
        hashmap.put('H',2);
        hashmap.put('j',2);
        hashmap.put('J',2);
        hashmap.put('k',2);
        hashmap.put('K',2);
        hashmap.put('l',2);
        hashmap.put('L',2);
        
        hashmap.put('z',3);
        hashmap.put('Z',3);
        hashmap.put('x',3);
        hashmap.put('X',3);
        hashmap.put('c',3);
        hashmap.put('C',3);
        hashmap.put('v',3);
        hashmap.put('V',3);
        hashmap.put('b',3);
        hashmap.put('B',3);
        hashmap.put('n',3);
        hashmap.put('N',3);
        hashmap.put('m',3);
        hashmap.put('M',3);
        
            
        ArrayList<String> list = new ArrayList();
        
        for(int i = 0; i<words.length; i++) {
            if(words[i].length() == 0) {
                list.add(words[i]);
            } else {
                int key = hashmap.get(words[i].charAt(0)).intValue();
                boolean flag = true;
                for(int j = 1; j<words[i].length(); j++) {
                    int tempKey = hashmap.get(words[i].charAt(j)).intValue();
                    if(tempKey != key) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    list.add(words[i]);
                }   
            }
        }
        return GetStringArray(list);
    }
    
    private static String[] GetStringArray(ArrayList<String> arr) { 
        String str[] = new String[arr.size()]; 
        for (int j = 0; j < arr.size(); j++) { 
            str[j] = arr.get(j); 
        } 
        return str; 
    } 
}