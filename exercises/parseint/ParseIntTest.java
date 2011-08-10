
interface IntParser {
  /**
   * Parses the given string to its integer
   * representation.
   *
   * If the given string doesn't represent an 
   * integer, it trows a NumberFormatException.
   *
   * @param intString The string to convert to an int.
   * @return The int.
   */
  int parseInt(String intString);
}

class IntParserImpl implements IntParser {

  /** 
   * O(n) implementation of the int parser.
   *
   * Implementation details:
   *   Eg. "245"
   *      5*10^0 + 4*10^1 + 2*10^2 = 5+40+200 = 245
   */
  public int parseInt(String str) {
    if( str == null || str.trim().equals("") ) throw new NumberFormatException("Input cannot be null or empty.");

    char[] chars = str.trim().toCharArray();
    boolean isNegative = chars[0] == '-';
    if( isNegative && chars.length == 1 ) {
      throw new NumberFormatException("Incorrect negative number");
    }

    int result = 0;
    for(int i=chars.length-1; i>=0; i--) {
      if( isNegative && i == 0 ) break; // The first character is the sign.
      if( chars[i] < '0' || chars[i] > '9' ) {
        throw new NumberFormatException("The given string doesn't represent an int.");
      }

      result += (((int)chars[i])-48)*((int)Math.pow(10, chars.length-1-i));
    }

    return isNegative ? (-1)*result : result;
  }
}


public class ParseIntTest {
  public static void main(String[] args) {
    // SUT
    IntParser parser = new IntParserImpl();

    // Positive number test
    String intStr = "18574";
    Assert.assertTrue( parser.parseInt(intStr) == 18574 );

    intStr = "999999";
    Assert.assertTrue( parser.parseInt(intStr) == 999999 );

    // Negative number test
    intStr = "-459";
    Assert.assertTrue( parser.parseInt(intStr) == -459 );

    // Single minus sign test
    intStr = "-";
    try {
      parser.parseInt(intStr);
      Assert.fail("Should throw an NumberFormatException when parsing a single minus sign.");
    } catch(NumberFormatException e) {
      Assert.pass();
    }

    // Character string test
    intStr = "notanumber";
    try {
      parser.parseInt(intStr);
      Assert.fail("Should throw an NumberFormatException when parsing a alpha str.");
    } catch(NumberFormatException e) {
      Assert.pass();
    }

    // Null input
    intStr = null;
    try {
      parser.parseInt(intStr);
      Assert.fail("Should throw an NumberFormatException when parsing a null str.");
    } catch(NumberFormatException e) {
      Assert.pass();
    }

    // Empty input
    intStr = "";
    try {
      parser.parseInt(intStr);
      Assert.fail("Should throw an NumberFormatException when parsing an empty str.");
    } catch(NumberFormatException e) {
      Assert.pass();
    }

    // str int bigger than MAX_INT.
    intStr = String.valueOf(Integer.MAX_VALUE+1);
    try {
      parser.parseInt(intStr);
      Assert.fail("Should throw a NumberFormatException if str int bigger than MAX_INT.");
    } catch(NumberFormatException e) {
      Assert.pass();
    }

    // str int smaller than MIN_INT.
    intStr = String.valueOf(Integer.MIN_VALUE+1);
    try {
      parser.parseInt(intStr);
      Assert.fail("Should throw a NumberFormatException if str int bigger than MAX_INT.");
    } catch(NumberFormatException e) {
      Assert.pass();
    }

  }
}






// =================================
//  Minimal testing framework
// =================================
class Assert {
  public static void assertTrue(boolean condition) {
    if( !condition ) throw new AssertError("Condition not met.");
  }

  public static void fail(String msg) { throw new AssertError(msg); }
  public static void pass() { /* NoOp */ }
}

class AssertError extends RuntimeException {
  AssertError(String msg) {
    super(msg);
  }
}
