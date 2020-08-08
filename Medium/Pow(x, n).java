class Solution {
    
    public double myPow(double x, int n) {
//         boolean check = false;
        
//         if(n<0) {
//             check = true;
//         }
        
//         int N = Math.abs(n);
        
//         double d = 0.0;
        
//         if(N>1000) {
//             do {
//                 d = d + getAnswer(x, 1000);
//                 N = N - 1000;
//             } while(N>1000);
            
//             if(N>0) {
//                 d = d + getAnswer(x, N);
//             }
//         } else {
//             d = getAnswer(x, N);   
//         } 
        
//         if(check) {
//             return 1/d;
//         }
//         return d;
        
        return Math.pow(x,n);
    }
    
    public static double getAnswer(double x, int n) {
        if(n == 0) {
            double d = 1.0;
            return d;
        }
        
        
        double answer = x*getAnswer(x,n-1);
        return answer;
    }
}