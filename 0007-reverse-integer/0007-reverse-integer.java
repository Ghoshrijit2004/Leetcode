class Solution {
    public int reverse(int x) {
      int n = Math.abs(x);
        int revNum = 0;
        while(n>0){
            int d = n%10;
             if (revNum > (Integer.MAX_VALUE - d) / 10) {
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