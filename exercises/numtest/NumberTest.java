import java.util.regex.*;
import java.util.*;

interface NumberTester {
  /*
   * Returns true if the input string is a number and false otherwise
   */
  public boolean isNumber(String numberToTest);
}

class NumberTesterRegexImpl implements NumberTester {

  private static final String numRegex = "^(\\d)*$";

  public boolean isNumber(String numberToTest) {
    if( numberToTest == null || numberToTest.length() == 0 ) return false;

    return Pattern.matches(numRegex, numberToTest);
  }
}

class NumberTesterLinearImpl implements NumberTester {

  private static final char[] digitChars = {'0','1','2','3','4','5','6','7','8','9'};

  /**
   * A linear O(n) complexity algorithm implementation.
   *
   * Note: even though it has a 'for' loop within a 'for' loop, it
   * is linear since the size of the inner 'for' loop is constant so
   * it doesn't grow with time, it is just that the slope of the line
   * is higher: 10x in this case.
   */
  public boolean isNumber(String numberToTest) {
    if( numberToTest == null || numberToTest.length() == 0 ) return false;

    char[] chars = numberToTest.toCharArray();
    for(char c : chars) {
      boolean isDigit = false;
      for(char numChar : digitChars) {
        if(c == numChar) {
          isDigit = true;
        }
      }
      if(!isDigit) return false;
    }
    return true;
  }
}


class NumberTesterBetterLinearImpl implements NumberTester {

  private static final char[] digitChars = {'0','1','2','3','4','5','6','7','8','9'};
  private static final Set<Character> digitSet = new HashSet<Character>();

  static { // Initialize the set. Happens on a static block so that it is only done once per class.
    for(char numChar : digitChars) {
      digitSet.add(numChar);
    }
  }

  /**
   * A linear O(n) complexity algorithm implementation.
   */
  public boolean isNumber(String numberToTest) {
    if( numberToTest == null || numberToTest.length() == 0 ) return false;

    char[] chars = numberToTest.toCharArray();
    for(char c : chars) {
      if( !digitSet.contains(c) ) return false;
    }
    return true;
  }
}

public class NumberTest {

  public static void main(String[] args) {

    // Testing the regex implementation
    // SUT
    NumberTester numTester = new NumberTesterRegexImpl();

    Assert.assertTrue( numTester.isNumber("2345") );
    Assert.assertTrue( numTester.isNumber("0002345") );
    Assert.assertTrue( !numTester.isNumber("abc") );
    Assert.assertTrue( !numTester.isNumber("2345a") );
    Assert.assertTrue( !numTester.isNumber("  2345") );
    Assert.assertTrue( !numTester.isNumber("") );
    Assert.assertTrue( !numTester.isNumber(null) );

    // Testing the linear implementation
    numTester = new NumberTesterLinearImpl();

    Assert.assertTrue( numTester.isNumber("2345") );
    Assert.assertTrue( numTester.isNumber("0002345") );
    Assert.assertTrue( !numTester.isNumber("abc") );
    Assert.assertTrue( !numTester.isNumber("2345a") );
    Assert.assertTrue( !numTester.isNumber("  2345") );
    Assert.assertTrue( !numTester.isNumber("") );
    Assert.assertTrue( !numTester.isNumber(null) );

    // Testing the better linear implementation
    numTester = new NumberTesterBetterLinearImpl();

    Assert.assertTrue( numTester.isNumber("2345") );
    Assert.assertTrue( numTester.isNumber("0002345") );
    Assert.assertTrue( !numTester.isNumber("abc") );
    Assert.assertTrue( !numTester.isNumber("2345a") );
    Assert.assertTrue( !numTester.isNumber("  2345") );
    Assert.assertTrue( !numTester.isNumber("") );
    Assert.assertTrue( !numTester.isNumber(null) );
  }
}



// =======================
// Small testing framework
// =======================
class Assert {
  public static void assertTrue(boolean condition) {
    if(!condition) {
      throw new AssertionError("The condition was not met.");
    }
  }
}

class AssertionError extends RuntimeException {
  AssertionError(String msg) {
    super(msg);
  }
}
