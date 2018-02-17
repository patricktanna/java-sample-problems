import java.util.*;

public class SubsequenceChecker{
    
    String W;
    int sPointer;
    int dPointer;
    
    // Method to sort the string array by length
    public static void lengthSort(String[] D) {
        Arrays.sort(D, new Comparator<String>() {
            public int compare(String s1,String s2) {
                return s1.length() - s2.length();
            }
        });
    
        for (int i = 0; i < D.length; i++)  {
            System.out.println(D[i]);
        }
    }
    
    // Method to quickly find first word with some length from sorted dictionary
    public static int findIndex(String[] D, int wordLength) {
        int p = D.length/2;
        int i;
        
        return i;
    }
    
    public static void checkSub(String S, String[] D) {
        
        
    }

    public static void main(String []args){
  
        String S = "abppplee";
        String[] D = {"pat", "able", "ale", "apple","bale", "kangaroo"};
    
        
        // Sort by length
        lengthSort(D);
        // Jump to first word where length equals input string length
        int i = findIndex(D, 4);
        System.out.print(i);
        
    }
}
