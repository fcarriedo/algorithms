import java.util.regex.*;

public class NumberTest {

  private static final String numRegex = "^(\\d)*$";

  /*
   * Returns true if the input string is a number and false otherwise
   */
  public static boolean isNumber(String numberToTest) {
    return Pattern.matches(numRegex, numberToTest);
  }

  public static void main(String[] args) {
    Assert.assertTrue( NumberTest.isNumber("2345") );
    Assert.assertTrue( NumberTest.isNumber("0002345") );
    Assert.assertTrue( !NumberTest.isNumber("abc") );
    Assert.assertTrue( !NumberTest.isNumber("2345a") );
    Assert.assertTrue( !NumberTest.isNumber("  2345") );
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
