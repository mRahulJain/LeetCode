class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        for(int i = s.length() - 1; i>=0; i--) {
            if(s.charAt(i) == 'I') {
                if(i != s.length() - 1) {
                    if(s.charAt(i+1) != 'I') {
                        answer -= 1;
                    } else {
                        answer += 1;
                    }
                } else {
                    answer += 1;   
                }
            } else if(s.charAt(i) == 'V') {
                if(i != s.length() - 1) {
                    if(s.charAt(i+1) == 'I' || s.charAt(i+1) == 'V') {
                        answer += 5;
                    } else {
                        answer -= 5;
                    }
                } else {
                    answer += 5;   
                }
            } else if(s.charAt(i) == 'X') {
                if(i != s.length() - 1) {
                    if(s.charAt(i+1) == 'I' || s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X') {
                        answer += 10;
                    } else {
                        answer -= 10;
                    }
                } else {
                    answer += 10;   
                }
            } else if(s.charAt(i) == 'L') {
                if(i != s.length() - 1) {
                    if(s.charAt(i+1) == 'I' || s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X' || s.charAt(i+1) == 'L') {
                        answer += 50;
                    } else {
                        answer -= 50;
                    }
                } else {
                    answer += 50;   
                }
            } else if(s.charAt(i) == 'C') {
                if(i != s.length() - 1) {
                    if(s.charAt(i+1) == 'I' || s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X' || s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') {
                        answer += 100;
                    } else {
                        answer -= 100;
                    }
                } else {
                    answer += 100;   
                }
            } else if(s.charAt(i) == 'D') {
                if(i != s.length() - 1) {
                    if(s.charAt(i+1) == 'I' || s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X' || s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C' || s.charAt(i+1) == 'D') {
                        answer += 500;
                    } else {
                        answer -= 500;
                    }
                } else {
                    answer += 500;   
                }
            } else if(s.charAt(i) == 'M') {
                answer += 1000;
            }
        }
        return answer;
    }
}