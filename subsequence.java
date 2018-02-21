import java.util.*;

public class SubsequenceChecker{
    
    /* **********************************************************
        
        This method sorts an input array of strings by length
        in decending order.

    ************************************************************/
    public static void lengthSort(String[] D) {
        Arrays.sort(D, new Comparator<String>() {
            public int compare(String s1,String s2) {
                return s2.length() - s1.length();
            }
        });
        
        /*
        for (int i = 0; i < D.length; i++)  {
            System.out.println(D[i]);
        }
        */
    }
    
    /* **********************************************************
        
        This method returns the index of the first dictionary
        word that is at least the length of the input string,
        given a dictionary that has been sorted in decending
        order.
        
        This is necessary as word A cannot be a subsquence of 
        word B if A is longer than B.

    ************************************************************/
    public static int findIndex(String[] D, String S) {
        
        int i = 0;
    
        while (D[i].length() > S.length() && i < D.length-1) {
            i = i + 1;
        }
        
        return i;
        
    }
    
    /* **********************************************************
        
        This method checks each word in the dictionary for
        a subsequence by starting with the first letter of
        the dictionary word and searching for a match in the
        input string. 
        
        i = the current word being analyzed from the dictionary
        j = the current character of the dictionary word
        k = the current character of the input string
        c = the running count of matching letters
        
        If the characters at the j & k indexes of their
        respective words match, j, k, & c are incremented.
        
        If the characters do not match, then k is incremented.
        
        If not all of the characters in the dictionary word
        cannot be found in order in the input string, the
        method moves onto the next word by incrementing i.
        
        This continues until either all words in the dictionary
        has been analyzed OR c equals the number of letters
        in the dictionary word, indicating all characters have
        been found in the input string.

    ************************************************************/
    public static String checkSub(String[] D, String S, int i) {
        
        String maxSub = "No subsequences found.";
        int j = 0;
        int k = 0;
        int c = 0;
        
        while (i < D.length && c != D[i].length()-1) {
            
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
        
        System.out.println("i:"+i+" j:"+j+" k:"+k+" c:"+c);
        
        if (c != 0) {
            maxSub = "Max subsequence = "+D[i];
        }
        
        return maxSub;

    }

    public static void main(String []args){
  
        // input string
        String S = "abppplee";
        
        // Dictionary
        String[] D = {"pat", "able", "ale", "apple","bale", "kangaroo", "looooongword"};
        // String[] D = {"patgfasggsdffg", "applepatgfasggsdffg"};
        // String[] D = {"pat", "ae"};
        
        // Sort by length
        lengthSort(D);
        
        // Check if all words in D are longer than S. If so, then a subsequence isn't possible.
        if (D[D.length-1].length() > S.length()) {
            System.out.println("No subsequences found.");
        } else {
            // Jump to first word where length equals input string length (right to left)
            int i = findIndex(D, S);
           
            // Check dictionary for subsequence
            String W = checkSub(D, S, i);
            System.out.println(W);
        }
        
    }
}
