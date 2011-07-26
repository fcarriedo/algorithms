import java.util.*;

interface TwoSum {

  /*
   * Stores @param input in an internal data structure
   */
  void store(int input);

  /*
   * Returns true if there is any pair of numbers in the internal data structure which have sum @param test, and false otherwise
   * For example, if the numbers 1, -2, 3, and 6 had been stored, the method should return true for 4, -1, and 9, but false for 10, 5, and 0
   */
  boolean test (int test);
}

public class TwoSumTest {
  public static void main(String[] args) {
    TwoSum twoSum = new TwoSumN2Impl();
    twoSum.store(1);
    twoSum.store(-2);
    twoSum.store(3);
    twoSum.store(6);

    // Positive tests
    Assert.assertTrue( twoSum.test(4) );
    Assert.assertTrue( twoSum.test(-1) );
    Assert.assertTrue( twoSum.test(9) );

    // Negative tests
    Assert.assertTrue( !twoSum.test(10) );
    Assert.assertTrue( !twoSum.test(5) );
    Assert.assertTrue( !twoSum.test(0) );
  }
}


/**
 * This implementation has a disastrous O(n2) complexity.
 *
 * Focuses all the logic into the 'test' algorithm, not in the 'store'
 */
class TwoSumN2Impl implements TwoSum {

  private List<Integer> internalStore = new ArrayList<Integer>();

  private Map<Integer,Boolean> cache = new HashMap<Integer,Boolean>();

  public void store(int input) {
    internalStore.add(input);
  }

  public boolean test(int test) {
    // Enhancement which would bring recurring cases
    // to a O(1)
    if(cache.get(test) != null) {
      return true;
    }

    for(int i=0; i<internalStore.size(); i++) {
      int first = internalStore.get(i);
      for(int j=0; j<internalStore.size(); j++) {
        if(i != j) {
          int second = internalStore.get(j);
          int sum = first+second;
          if(sum == test) {
            cache.put(test, true);
            return true;
          }
        }
      }
    }

    return false;
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
