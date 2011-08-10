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

  private static Pattern numPattern;

  NumberTesterRegexImpl() {
    numPattern = Pattern.compile(numRegex);
  }

  public boolean isNumber(String numberToTest) {
    if( numberToTest == null || numberToTest.length() == 0 ) return false;
    return numPattern.matcher(numberToTest).matches();
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

/**
 * O(n) implementation that does a 'char in int range comparison'
 * to verify it its a number.
 */
class NumberTesterCharCompImpl implements NumberTester {

  public boolean isNumber(String numberToTest) {
    if( numberToTest == null || numberToTest.length() == 0 ) return false;

    char[] chars = numberToTest.toCharArray();
    for(int c : chars) {
      if( c<'0' || c>'9' ) return false; // compare its integer representations.
    }
    return true;
  }
}

public class NumberTest {

  private static final int MAX_ROUNDS = 100000;

  public static void main(String[] args) {
    // SUT
    NumberTester numTester = null;

    // Testing the regex implementation
    numTester = new NumberTesterRegexImpl();
    long elapsedTimeMillis = performTest(numTester);
    System.out.println("RegEx: " + elapsedTimeMillis + "ms");

    // Testing the linear implementation
    numTester = new NumberTesterLinearImpl();
    elapsedTimeMillis = performTest(numTester);
    System.out.println("O(n)  10x: " + elapsedTimeMillis + "ms");

    // Testing the better linear implementation
    numTester = new NumberTesterBetterLinearImpl();
    elapsedTimeMillis = performTest(numTester);
    System.out.println("O(n) Hash: " + elapsedTimeMillis + "ms");

    // Testing the char comparison linear implementation
    numTester = new NumberTesterCharCompImpl();
    elapsedTimeMillis = performTest(numTester);
    System.out.println("(This is the winner!): O(n) char comp: " + elapsedTimeMillis + "ms");
  }

  /**
   * Executes as set of tests in multiple rounds and times its performance.
   *
   * @param numTester the SUT
   * @return The elapsed time that it took to perform the test.
   */
  private static long performTest(NumberTester numTester) {
    long begin = System.currentTimeMillis();
    for (int i=0; i<MAX_ROUNDS; i++) {
      Assert.assertTrue( numTester.isNumber("2345") );
      Assert.assertTrue( numTester.isNumber("0002345") );
      Assert.assertTrue( !numTester.isNumber("abc") );
      Assert.assertTrue( !numTester.isNumber("2345a") );
      Assert.assertTrue( !numTester.isNumber("  2345") );
      Assert.assertTrue( !numTester.isNumber("") );
      Assert.assertTrue( !numTester.isNumber(null) );
    }
    long end = System.currentTimeMillis();

    return end-begin;
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
