# Leetcode 
7.  Reverse Integer -
class Solution {
    public int reverse(int x) {
      int n = Math.abs(x);    // Math.abs using for absolute value of a integer
        int revNum = 0;
        while(n>0){
            int d = n%10;
             if (revNum > (Integer.MAX_VALUE - d) / 10) {     // creating to check the overflow of integer value
                return 0;
            }
            revNum = revNum*10 + d;
            n = n/10;  
                       
        }
          if (x < 0) {
            revNum = -revNum;
        }
          return revNum; 
    }
}
9. Palindrome Number
    class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int n = x;
        int revNum= 0 ;
        while(n>0){
            int d = n%10;
            revNum = revNum*10 + d;
            n = n/10;
        }
        if(revNum==x){
            return true;
        }
        else{
            return false;
        }
    }
}
