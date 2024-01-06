/*Brianna Penkala 
 * This class has several methods including one that checks if there are only english letters in the string, one that replaces the kth instance of a char,
 * one that interweaves two strings, one that replaces the middle letters of a word with _, one that only records the nth words in a string, and one that truncates 
 * a string only at the legal spaces.
*/

public class HW2 {
  
  //this method returns true if the string only has english letters and false if it does not 
  public static boolean onlyEnglishLetters (String s) {
    //the loop will continue until the index reaches the end of the string. If there is a non-english letter it will return false.
    for (int index = 0; index < s.length(); index ++) {
      if (Character.isLetter(s.charAt(index)))
        ;
      else 
        return false;
    }
    return true;
  }
  
  //this method replaces char a with char b if char a occurs k times
  public static String replaceKth (char a, char b, int k, String s) {
    StringBuilder builder = new StringBuilder();
    int count = 1; //counts how many times a occurs in the string
    //the loop will continue until the end of the string is reached. It will append the char at the index from the string unless count == k, when it will append b for a.
    for (int index = 0; index < s.length(); index ++) {
      if ((count < k || count > k) && (s.charAt(index) == a)) {
          builder.append(s.charAt(index));
          count ++;
      }
      else if ((count == k) && (s.charAt(index) == a)) {
        builder.append(b);
        count ++; 
      }
      else 
        builder.append(s.charAt(index));
    }
    return builder.toString();
  }
  
  //this method interweaves the two strings and adds the rest of the one that is longer if they are different lengths
  public static String interWeave (String s, String t) {
    StringBuilder builder = new StringBuilder();
    /* this loop will have an index for each string and continue until both string lengths are reached. It will append the next character of the string until one 
     * runs out, then it will then append the rest of the string with the longer length if they are different lengths.
     */
    for (int index1 = 0, index2 = 0; index1 < s.length() || index2 < t.length(); index1 ++, index2 ++) {
      if (index1 >= s.length()) 
       builder.append(t.charAt(index2));
      else if (index2 >= t.length()) 
       builder.append(s.charAt(index1));
      else {
       builder.append(s.charAt(index1));
       builder.append(t.charAt(index2));
       }                
    }
    return builder.toString();
  }
  
  //this method replaces the middle letters of each word with _
  public static String blankWords (String s) {
    StringBuilder builder = new StringBuilder();
    int index = 0;
    /*this loop will run until the index reaches s.length() - 1. If the char at the index is a letter and before or after the index is a letter (but not both), 
     * it will append the char to the StringBuilder. If the character is a letter and is in the middle of two letters, it will append an _ to the
     * StringBuilder. If the char at the index is not a letter or the index = 0, it will append the char at the index.
     */
    while (index < s.length() - 1) {
      if (Character.isLetter(s.charAt(index)) && index > 0) {
        if (!(Character.isLetter(s.charAt(index + 1)))  || !(Character.isLetter(s.charAt(index - 1)))) //if it is a first or last letter
              builder.append(s.charAt(index));
        else
              builder.append('_');
      }                   
      else 
           builder.append(s.charAt(index)); 
      index ++;
    }  
    if (s.length() > 0)
      builder.append(s.charAt(index));
    return builder.toString();
  }

//this method includes every nth word in a string
 public static String nthWord (int n, String s) {
  StringBuilder builder = new StringBuilder();
  int count = 0; //counts how many words are in the string
  /*this loop will run until the index reaches the string length. If the next index is not out of range and is a space, and the index is a letter, count is increased.
   * If count % n == 0, that word is appended to the StringBuilder.
   */
  for (int index = 0; index < s.length(); index++) { 
    if (index + 1 < s.length() && Character.isLetter(s.charAt(index)) && s.charAt(index + 1) == ' ') { //if it is the end of a word
      count ++;
    }
    else if (n > 0 && count % n == 0 && Character.isLetter(s.charAt(index))){ //when count is reached 
      if (builder.length() > 0)
        builder.append(' ');
      while ((index < s.length() ) && (s.charAt(index) != ' ')) { //appends the nth word
        builder.append(s.charAt(index));
        index ++;
      }
        count ++;
      }
    }
   return builder.toString();
  }
 
 //this method truncates the string up to the hyphen that is at least as long as the input length
 public static String truncateAfter (int x, String s) {
   StringBuilder builder = new StringBuilder();
   /*this loop will run until the index reaches the string length. If the StringBuilder length is less than x and the character at the index is not a hyphen or space, 
    * that char is appended. If adding one char to the StringBuilder will reach x and the index is a hyphen, the hyphen is added. If adding one char to the StringBuilder will 
    * reach x and the index is a space, then it will add the chars up to the next hyphen. If x isn't reached with the next append to StringBuilder and it reaches a 
    * space, the space is included in the StringBuilder.
    */
   for (int index = 0; index < s.length(); index++) {
     if (builder.length() < x && s.charAt(index) != ' ' && s.charAt(index) != '-') 
       builder.append(s.charAt(index));
     else if (builder.length() + 1 == x && s.charAt(index) == '-') //if x ends at a hyphen
       builder.append('-'); 
     else if (builder.length() + 1 == x && s.charAt(index) == ' ') { //if x ends at a space
       //this loop appends chars to the StringBuilder until the next hyphen is reached, then adds a hyphen to the StringBuilder
       for (; s.charAt(index) != '-'; index++) {
         builder.append(s.charAt(index));
       }
       builder.append('-');
     }
     else if (builder.length() + 1 < x && s.charAt(index) == ' ') //if index is at a space and x isn't reached
       builder.append(' ');  
   }
   return builder.toString();
 }
}
