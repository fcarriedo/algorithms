import static org.junit.Assert.*;

class Appender {

  public static final int MAX_CHARS = 10;

  /**
   * This method fills the string with '0' pre-appending
   * them until the given input string reaches its max length.
   *
   * @param input The string to pre-append.
   */
  public static String preAppend(String input) {
    int charsToFill = input == null ? MAX_CHARS : MAX_CHARS-input.length();

    if(charsToFill < 0) {
      return input.substring(-charsToFill);
    } else {
      StringBuilder result = new StringBuilder();
      for(int i=0; i<charsToFill; i++) {
        result.append("0");
      }
      result.append(input == null ? "" : input);
      return result.toString();
    }
  }
}

public class ZeroFillTest {

  @Test
  public void testNormalPath() {
    String account = "abc";
    String result = Appender.preAppend(account);

    String expected = "0000000abc";

    assertEquals("The account should be 10 chars long", 10, result.length());
    assertEquals(expected, result);
  }

  @Test
  public void testNullInput() {
    String account = null;

    String result = Appender.preAppend(account);

    String expected = "0000000000";

    assertEquals("A null account should still be be 10 chars long", 10, result.length());
    assertEquals(expected, result);
  }

  @Test
  public void testAccountLargerThanPermitted() {
    String account = "abcdefg1234567";

    String result = Appender.preAppend(account);

    String expected = "efg1234567";

    assertEquals("A longer string should still be 10 chars long after", 10, result.length());
    assertEquals(expected, result);
  }
}

