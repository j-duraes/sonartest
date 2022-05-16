
01 private static byte[] getInts(String digs) {
02     byte[] result = new byte[digs.length()];                
03     for (int i = 0; i < digs.length(); i++) {                
04         char c = digs.charAt(i);                        
05         if (c < '0' || c > '9') {                    
06             throw new IllegalArgumentException("Invalid string " + c    
07                     + " at position " + i);
08         }
09         result[digs.length() - 1 - i] = (byte) (c - '0');            
10     }
11     return result;                            
12 }



 public static String getResult(String num1, String num2) {
     byte[] left = getInts(num1);                        
     byte[] right = getInts(num2);                    
     byte[] result = new byte[left.length + right.length];            
     for (int rightPos = 0; rightPos < right.length; rightPos++) {        
         byte rightDigit = right[rightPos];                
         byte temp = 0;                            
         for (int leftPos = 0; leftPos < left.length; leftPos++) {        
             temp += result[leftPos + rightPos];                
             temp += rightDigit * left[leftPos];                
             result[leftPos + rightPos] = (byte) (temp % 10);        
             temp /= 10;                            
         }
         int destPos = rightPos + left.length;                
         while (temp != 0) {                        
             temp += result[destPos] & 0xFFFFFFFFL;            
             result[destPos] = (byte) (temp % 10);                
             temp /= 10;                            
             destPos++;                            
         }
     }
     StringBuilder stringResultBuilder = new StringBuilder(result.length);    
     for (int i = result.length - 1; i >= 0; i--) {            
         byte digit = result[i];                        
         if (digit != 0 || stringResultBuilder.length() > 0) {        
             stringResultBuilder.append((char) (digit + '0'));        
         }
     }
     return stringResultBuilder.toString();                
 }

 public static void main(String[] args) {
     System.out.println(getResult("1234","56789"));                
 }



