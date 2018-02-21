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
        
        String maxSub = "No subsequences found.";
        int j = 0;
        int k = 0;
        int c = 0;
        
        while (i < D.length-1 && c != D[i].length()-1) {
            
            System.out.println("i:"+i+" j:"+j+" k:"+k+" c:"+c);
            if (j > D[i].length()-1 || k > S.length()-1) {
                i = i + 1;
                j = 0;
                k = 0;
                c = 0;
            } else if (D[i].charAt(j) == S.charAt(k)) {
                j = j + 1;
                k = k + 1;
                c = c + 1;
            } else {
                k = k + 1;
            }
        
        }
        
        // System.out.println("i:"+i+" j:"+j+" k:"+k+" c:"+c);
        
        if (c != 0) {
            maxSub = D[i];
        }
        
        return maxSub;

    }

    public static void main(String []args){
  
        String S = "abppplee";
        // String[] D = {"pat", "able", "ale", "apple","bale", "kangaroo", "looooongword"};
        String[] D = {"pat"};
        
        // Sort by length
        lengthSort(D);
        
        // Check if all words in D are longer than S
        if (D[D.length-1].length() > S.length()) {
            System.out.println("No subsequences found in Dictionary");
        }
        
        // Jump to first word where length equals input string length (right to left)
        int i = findIndex(D, S);
       
        // Check dictionary for subsequence
        String W = checkSub(D, S, i);
        System.out.println("Max subsequence found: " + W);
        
    }
}
