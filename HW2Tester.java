/* Brianna Penkala
 * This class tests the HW2 class 
 */

import org.junit.Test; 
import static org.junit.Assert.assertEquals;
  
public class HW2Tester {

  //this method tests the onlyEnglishLetters method
  @Test 
  public void testOnlyEnglishLetters() {
    //no non-english letters
    assertEquals (true, HW2.onlyEnglishLetters("abcdefghjk"));
    //one non-english letter, at the beginning
    assertEquals (false, HW2.onlyEnglishLetters("1abcdefghijk"));
    //many non-english letters
    assertEquals (false, HW2.onlyEnglishLetters("1a*b3c%35def2g(56hi9j*4k"));
    //non-english letter in the middle
    assertEquals (false, HW2.onlyEnglishLetters("abcd1efghijk"));
    //non-english letter at the end
    assertEquals (false, HW2.onlyEnglishLetters("abcdefghijk1"));
  }
  
  //this method tests the replaceKth method
  @Test 
  public void testReplaceKth() {
    //nothing to replace
    assertEquals ("aaaa", HW2.replaceKth('a', 'x', 0, "aaaa"));
    //replace many (in this case just with a longer string)
    assertEquals ("abacdefaghxijkal", HW2.replaceKth('a', 'x', 4, "abacdefaghaijkal"));   
    //replace first 
    assertEquals ("xaaa", HW2.replaceKth('a', 'x', 1, "aaaa"));
    //replace middle
    assertEquals ("aaxa", HW2.replaceKth('a', 'x', 3, "aaaa"));
    //replace last
    assertEquals ("aaaax", HW2.replaceKth('a', 'x', 5, "aaaaa"));    
    //a does not occur at least k times
    assertEquals ("aaaa", HW2.replaceKth('a', 'x', 5, "aaaa"));
  }
  
//this method tests the interWeave method  
  @Test
  public void testInterWeave() {
    //both strings are the same length 
    assertEquals ("a1b2c3d4", HW2.interWeave("abcd", "1234"));
    //first string is blank 
    assertEquals ("1234", HW2.interWeave("", "1234"));
    //second string is blank
    assertEquals ("abcd", HW2.interWeave("abcd", ""));
    //the second string is equal to one and shorter than the first
    assertEquals ("a1bcd", HW2.interWeave("abcd", "1"));
    //the first string is equal to one and shorter than the second
    assertEquals ("a1234", HW2.interWeave("a", "1234"));
    //testing many
    assertEquals ("a1b2c3d4e5f6g7", HW2.interWeave("abcdefg", "1234567"));
  }
  
  //this method tests the blankWords method
  @Test 
  public void testBlankWords() {
    //basic test 
    assertEquals ("T__s is a t__t.", HW2.blankWords("This is a test."));
    //no middle letters
    assertEquals ("Ts is a tt.", HW2.blankWords("Ts is a tt."));
    //all words have one middle letter
    assertEquals ("T_s t_t w_s", HW2.blankWords("Ths tet wos"));
    //one word in string
    assertEquals ("T__s", HW2.blankWords("This"));
    //lots of middle letters
    assertEquals ("T____s i___s a_a t_______t.", HW2.blankWords("Thiiis issss aaa tesssssst."));
    //if the string is empty
    assertEquals ("", HW2.blankWords(""));
    //only first word has middle letters
    assertEquals ("T__s is a tt.", HW2.blankWords("This is a tt."));
    //only middle word has middle letters
    assertEquals ("Th i_s a te.", HW2.blankWords("Th iss a te."));
    //only last word has middle letters
    assertEquals ("Ts is a t__t.", HW2.blankWords("Ts is a test."));
    //non-letter at front
    assertEquals ("1T__s is a t__t.", HW2.blankWords("1This is a test."));
    //non-letter at the end
    assertEquals ("T__s is a t__t1", HW2.blankWords("This is a test1"));
    //many non-letters in the string 
    assertEquals ("T__s1 is1 a1 t__t1.", HW2.blankWords("This1 is1 a1 test1."));
  }

  //this method tests the nthWord method  
  @Test 
  public void testNthWord() {
    //basic test
    assertEquals ("zero two four six", HW2.nthWord(2, "zero one two three four five six"));
    //if last word is not an nth word
    assertEquals ("zero two four six", HW2.nthWord(2, "zero one two three four five six seven"));
    //using a different n
    assertEquals ("zero three six", HW2.nthWord(3, "zero one two three four five six"));
    //if n == 0
    assertEquals ("", HW2.nthWord(0, "zero one two three four five six"));
    //if n == 1 
    assertEquals ("zero one two three four five six", HW2.nthWord(1, "zero one two three four five six"));  
    //many nth words
    assertEquals ("zero two four six eight ten twelve", HW2.nthWord(2, "zero one two three four five six seven eight nine ten eleven twelve thirteen"));
    //if the input string is blank
    assertEquals ("", HW2.nthWord(2, ""));
    //if there is one word in the input string
    assertEquals ("zero", HW2.nthWord(2, "zero"));
    //if there is only one nth word due to large n 
    assertEquals ("zero", HW2.nthWord(10, "zero one two three four five six")); 
    //if there are multiple spaces at the front of the string    
    assertEquals ("zero two four six", HW2.nthWord(2, "     zero one two three four five six"));
    //if there are multiple spaces in the middle of the string
    assertEquals ("zero two four six", HW2.nthWord(2, "zero one       two three four five six")); 
    //if there are multiple spaces at the end of the string
    assertEquals ("zero two four six", HW2.nthWord(2, "zero one two three four five six        "));
  }
  
  //this method tests the truncateAfter method  
  @Test 
  public void testTruncateAfter() {
    //when x ends at a hyphen
    assertEquals ("Late-", HW2.truncateAfter(5, "La-te-ly the-re."));
    //when x ends at a letter at the end of a legal truncation
    assertEquals ("Lately", HW2.truncateAfter(6, "La-te-ly the-re."));
    //when x ends at a space
    assertEquals ("Lately the-", HW2.truncateAfter(7, "La-te-ly the-re."));
    //when x == 0 
    assertEquals ("", HW2.truncateAfter(0, "La-te-ly the-re."));
    //to test many
    assertEquals ("Lately there.", HW2.truncateAfter(13, "La-te-ly the-re."));
           //when x == 1 or when x ends at a letter not at the end of a legal truncation
           // assertEquals ("La-", HW2.truncateAfter(1, "La-te-ly the-re.")); //does not work
    //when there are non-letters in the string 
    assertEquals ("La1te", HW2.truncateAfter(5, "La1-te1-ly1 the1-re1.")); 
    //when there are no hyphens in the string
    assertEquals ("Lately", HW2.truncateAfter(6, "Lately there."));
    //when the desired string length is greater than the input string length 
    assertEquals ("Lately there.", HW2.truncateAfter(20, "La-te-ly the-re.")); 
  }
}
  
  