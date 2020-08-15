class Solution {
    public boolean judgeCircle(String moves) {
        int startX = 0;
        int startY = 0;
        for(int i = 0; i<moves.length(); i++) {
            if(moves.charAt(i) == 'L') {
                startX--;
            } else if(moves.charAt(i) == 'R') {
                startX++;
            } else if(moves.charAt(i) == 'U') {
                startY++;
            } else if(moves.charAt(i) == 'D') {
                startY--;
            }
        }
        if(startX == 0 && startY == 0) {
            return true;
        }
        return false;
    }
}