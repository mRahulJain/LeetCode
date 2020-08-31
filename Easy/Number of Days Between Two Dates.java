class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int leap = 1972;
        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        
        String[] myDate1 = date1.split("\\-");
        int year1 = Integer.parseInt(myDate1[0]);
        int month1 = Integer.parseInt(myDate1[1]);
        int day1 = Integer.parseInt(myDate1[2]);
        
        String[] myDate2 = date2.split("\\-");
        int year2 = Integer.parseInt(myDate2[0]);
        int month2 = Integer.parseInt(myDate2[1]);
        int day2 = Integer.parseInt(myDate2[2]);
        
        int answer = 0;
        
        if(year1>year2) {
            while(year1!=year2 || month1!=month2) {
                answer += days[month2];
                if(month2 == 2) {
                    if((year2-leap)%4==0) {
                        if(year2!=2100) {
                            answer += 1;
                        }
                    }
                }
                month2++;
                if(month2>12) {
                    month2 = 1;
                    year2++;
                }
            }
            answer -= day2;
            answer += day1;
        } else if(year1<year2) {
            while(year1!=year2 || month1!=month2) {
                answer += days[month1];
                if(month1 == 2) {
                    if((year1-leap)%4==0) {
                        if(year1!=2100) {
                            answer += 1;
                        }
                    }
                }
                month1++;
                if(month1>12) {
                    month1 = 1;
                    year1++;
                }
            }
            answer -= day1;
            answer += day2;
        } else {
            if((year1-leap)%4 == 0) {
                if(year1!=2100) {
                    days[2] = 29;
                }
            }
            if(month1>month2) {
                while(month2!=month1) {
                    answer += days[month2];
                    month2++;
                }
                answer -= day2;
                answer += day1;
            } else if(month1<month2){
                while(month1!=month2) {
                    answer += days[month1];
                    month1++;
                }
                answer -= day1;
                answer += day2;
            } else {
                answer = Math.abs(day1-day2);
            }
        }
        
        return answer;
    }
}