class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0; 
        int y = 0;
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        ArrayList<Integer> first = new ArrayList();
        first.add(x);
        first.add(y);
        list.add(first);
        
        for(int i = 0; i<path.length(); i++) {
            if(path.charAt(i) == 'N') {
                y++;
            } else if(path.charAt(i) == 'S') {
                y--;
            } else if(path.charAt(i) == 'E') {
                x++;
            } else if(path.charAt(i) == 'W') {
                x--;
            }
            
            ArrayList<Integer> temp = new ArrayList();
            temp.add(x);
            temp.add(y);
            
            if(list.contains(temp)) {
                return true;
            }
            list.add(temp);
        }
        return false;
    }
}