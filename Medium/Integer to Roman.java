class Solution {
    public String intToRoman(int num) {
        String answer = "";
        int N = num;
        int iterator = 0;
        while(N>0) {
            int rem = N%10;
            int temp = rem*((int)Math.pow(10, iterator));
            
            String myString = makeString(temp, iterator+1);
            answer = myString + answer;
            
            iterator++;
            N = N/10;
        }
        return answer;
    }
    
    private String makeString(int temp, int digits) {
        String toReturn = "";
        if(digits == 1) {
            if(temp <= 3) {
                while(temp>0) {
                    toReturn += "I";
                    temp--;
                }
            } else if(temp <= 5) {
                if(temp == 4) {
                    toReturn = "IV";
                } else {
                    toReturn = "V";
                }
            } else if(temp <= 8) {
                toReturn  += "V";
                while(temp>5) {
                    toReturn += "I";
                    temp--;
                }
            } else {
                if(temp == 9) {
                    toReturn = "IX";
                } else {
                    toReturn = "X";
                }
            }
        } else if(digits == 2) {
             if(temp <= 30) {
                while(temp>0) {
                    toReturn += "X";
                    temp = temp - 10;
                }
            } else if(temp <= 50) {
                if(temp == 40) {
                    toReturn = "XL";
                } else {
                    toReturn = "L";
                }
            } else if(temp <= 80) {
                toReturn  += "L";
                while(temp>50) {
                    toReturn += "X";
                    temp = temp - 10;
                }
            } else {
                if(temp == 90) {
                    toReturn = "XC";
                } else {
                    toReturn = "C";
                }
            }
        } else if(digits == 3) {
            if(temp <= 300) {
                while(temp>0) {
                    toReturn += "C";
                    temp = temp - 100;
                }
            } else if(temp <= 500) {
                if(temp == 400) {
                    toReturn = "CD";
                } else {
                    toReturn = "D";
                }
            } else if(temp <= 800) {
                toReturn  += "D";
                while(temp>500) {
                    toReturn += "C";
                    temp = temp - 100;
                }
            } else {
                if(temp == 900) {
                    toReturn = "CM";
                } else {
                    toReturn = "M";
                }
            }
        } else if(digits == 4) {
            if(temp <= 3000) {
                while(temp>0) {
                    toReturn += "M";
                    temp = temp - 1000;
                }
            }
        }
        return toReturn;
    }
}