/*
A palindrome program that retrieves the longest palindrome present in the inputed string.
Author: Jeric Cereno
*/
import java.util.*;
 
public class Palindrome {
  public static void main(String[] args) {
    //string variable
    String inp = ""; 
    Scanner in = new Scanner(System.in);
    
    while(in.hasNextLine()){
      inp = in.nextLine();
    }

    //limit input value 
    inp.substring(0, Math.min(1000000,inp.length()));

    for(int i=0;i<=inp.length();i++) {
      for(int j=i;j<inp.length();j++) {
        if(checkPalindrome(inp.substring(i,j+1)))
          System.out.println(inp.substring(i,j+1));
      }
    }  
  }

  //check if palindrome and if the longest
  public static boolean checkPalindrome(String str) {
    int lengthMax = 1;
    int strLength = str.length();
    lengthMax = longestPalSubstr(str);
    for (int i=0; i<str.length()/2; i++) {
      if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
        return false;
      }
      if(strLength==lengthMax) {   
        return true;
      }
    } return true;
  }

  //length of longest palindrome
  public static int longestPalSubstr(String str) { 
    int maxLength = 1; 
    int start = 0; 
    int len = str.length(); 
    int low, high; 
  
    for (int i = 1; i < len; ++i) { 
      low = i - 1; 
      high = i; 
      while (low >= 0 && high < len 
               && str.charAt(low) == str.charAt(high)) { 
        if (high - low + 1 > maxLength) { 
          start = low; 
          maxLength = high - low + 1; 
        } 
        --low; 
        ++high; 
      } 
  
      low = i - 1; 
      high = i + 1; 
      while (low >= 0 && high < len 
              && str.charAt(low) == str.charAt(high)) { 
        if (high - low + 1 > maxLength) { 
          start = low; 
          maxLength = high - low + 1; 
        } 
        --low; 
        ++high; 
      } 
    }    
    return maxLength; 
    } 
}

