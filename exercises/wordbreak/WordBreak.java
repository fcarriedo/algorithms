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
    if( dict.contains(input) ) return input;
    int len = input.length();
    StringBuilder result = null;
    for(int beginIx=0, endIx=0; endIx<len+1; endIx++) {
      String potentialWord = input.substring(beginIx, endIx);
      if( dict.contains(potentialWord) ) {
        if( result == null ) result = new StringBuilder();
        result.append(potentialWord + " ");
        beginIx = endIx;
      }
    }
    return result == null ? null : result.toString().trim();
  }

  String segmentString(String input) {
    if (dict.contains(input)) return input;
    int len = input.length();
    for (int i = 1; i < len; i++) {
      String prefix = input.substring(0, i);
      if (dict.contains(prefix)) {
        String suffix = input.substring(i, len);
        String segSuffix = segmentString(suffix);
        if (segSuffix != null) {
          return prefix + " " + segSuffix;
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    WordBreak wordBreaker = new WordBreak();

    String input = "thisistheendoftheendlesswar";

    String result = wordBreaker.wordBreak(input);
    Assert.assertTrue("this is the end of the end less war".equals(result));

    result = wordBreaker.segmentString(input);
    Assert.assertTrue("this is the end of the end less war".equals(result));
  }

  private void initDictionary() {
    dict.add("apple");
    dict.add("pie");
    dict.add("this");
    dict.add("is");
    dict.add("the");
    dict.add("end");
    dict.add("of");
    dict.add("war");
    dict.add("endless");
    dict.add("less");
  }

}

class Assert {
  public static void assertTrue(boolean condition) {
    if( !condition ) {
      System.out.println("Your implementation failed miserably!");
    } else {
      System.out.println("You rocked on this one!");
    }
  }
}
