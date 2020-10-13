class Solution {
    public String minRemoveToMakeValid(String s) {
        return operate(s);
    }
    
    public static String operate(String str) {
		StringBuilder sb1 = new StringBuilder();
		
		int open = 0;
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				open++;
			} else if(str.charAt(i) == ')') {
				if(open == 0) {
					continue;
				}
				open--;
			}
			sb1.append(str.charAt(i));
		}
		
		StringBuilder sb2 = new StringBuilder();
		for(int i = sb1.length()-1; i>=0; i--) {
			if(sb1.charAt(i) == '(' && open > 0) {
				open--;
				continue;
			}
			sb2.append(sb1.charAt(i));
		}
		return sb2.reverse().toString();
	}
}