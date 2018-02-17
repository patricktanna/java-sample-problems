import java.util.*;

public class SubsequenceChecker{
    
    // Method to sort the string array by length
    public static void lengthSort(String[] D) {
        Arrays.sort(D, new Comparator<String>() {
            public int compare(String s1,String s2) {
                return s2.length() - s1.length();
            }
        });
    
        for (int i = 0; i < D.length; i++)  {
            System.out.println(D[i]);
        }
    }
    
    // Method to find first word with minimum S.length()
    public static int findIndex(String[] D, String S) {
        
        int i = 0;
    
        while (D[i].length() > S.length()) {
            i = i + 1;
        }
        
        return i;
        
    }
    
    public static String checkSub(String[] D, String S, int i) {
        
        String maxSub;
        
        for (int i = 0; i < D.length; i++) {
            
        }
        
        return maxSub;
    }

    public static void main(String []args){
  
        String S = "abppplee";
        String[] D = {"pat", "able", "ale", "apple","bale", "kangaroo", "looooongword"};
        
        // Sort by length
        lengthSort(D);
        
        // Check if all words in D are longer than S
        if (D[D.length-1].length() > S.length()) {
            System.out.println("No subsequences found in Dictionary");
        }
        
        // Jump to first word where length equals input string length (right to left)
        int i = findIndex(D, S);
        System.out.println(i);
       
        // Check dictionary for subsequence
        String W = checkSub(D, S, i);
        System.out.println(W);
        
    }
}
