/**
 * Given an input string and a dictionary of words,
 * segment the input string into a space-separated
 * sequence of dictionary words if possible. For
 * example, if the input string is "applepie" and
 * dictionary contains a standard set of English words,
 * then we would return the string "apple pie" as output.
 */

import java.util.*;

public class WordBreak {

  private Set<String> dict = new HashSet<String>();

  public WordBreak() {
    initDictionary();
  }

  private String wordBreak(String input) {
    int length = input.length();
    StringBuilder result = null;
    for(int endIx=0, beginIx=0; endIx<length+1; endIx++) {
      String potentialWord = input.substring(beginIx, endIx);
      if( dict.contains(potentialWord) ) {
        if( result == null ) result = new StringBuilder();
        result.append(potentialWord + " ");
        beginIx = endIx;
      }
    }
    return result == null ? null : result.toString().trim();
  }

  public static void main(String[] args) {

    String input = "applepie";

    String result = new WordBreak().wordBreak(input);

    if( !result.equals("apple pie") ) {
      System.out.println("Your implementation failed miserably.");
    } {
      System.out.println("Neat implementation!");
    }
  }

  private void initDictionary() {
    dict.add("apple");
    dict.add("pie");
  }

}
