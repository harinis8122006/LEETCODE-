class Solution {
    public int[] plusOne(int[] digits) {
      int length_digit = digits.length;
      for(int i=length_digit-1;i>=0;i--){
         if(digits[i] < 9){
            digits[i]++;
            return digits;
         }
         digits[i]=0;
      }
      int []arr = new int[length_digit+1];
      arr[0] = 1; 
      return arr;
    }
}