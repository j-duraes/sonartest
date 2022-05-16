
 public static int getResult(int[] sequence, int lower, int upper) {
     int result = 0;                        
     if (sequence == null)                    
         return result;                    
     for (int n : sequence) {                    
         if (n>=lower && n<=upper)                
             result++;                    
     }
     return result;
 }

 public static void main(String[] args) {
    int[] sequence = {-7, 1, 5, 2, -4, 3, 0};            
    int result = getResult(sequence,2,4);            
    System.out.println("Result = " + result);            
 }



