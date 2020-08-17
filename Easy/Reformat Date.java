class Solution {
    public String reformatDate(String date) {
        String[] arr = date.split("\\s+");
        HashMap<String, String> month = new HashMap();
        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");
        String d = "";
        int i = 0;
        while(arr[0].charAt(i) != 't' && arr[0].charAt(i) != 'r' && arr[0].charAt(i) != 's' && arr[0].charAt(i) != 'n') {
            d += arr[0].charAt(i);
            i++;
        }
        if(Integer.parseInt(d) < 10) {
            d = "0"+d;
        }
        
        return arr[2]+"-"+month.get(arr[1])+"-"+d;
    }
}