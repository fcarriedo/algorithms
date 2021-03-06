import java.util.*;

interface TwoSum {

  /*
   * Stores the given number into an internal data structure
   */
  void store(int input);

  /*
   * Returns true if there is any pair of numbers in the internal
   * data structure which have sum @param test,and false otherwise.
   *
   * Example: if the numbers 1, -2, 3, and 6 had been stored,
   *          the method should return true for 4, -1, and 9,
   *          but false for 10, 5, and 0.
   */
  boolean test (int test);
}

public class TwoSumTest {
  public static void main(String[] args) {

    // =========================
    // Testing the O(n) implementation (linear)
    // =========================
    TwoSum twoSum = new TwoSumLinearImpl();
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


    // =========================
    // Testing the O(n2) implementation
    // =========================
    twoSum = new TwoSumN2Impl();
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
 * Implementation with linear O(n) complexity on 'store'
 * and O(1) complexity on 'test'.
 *
 * Focuses logic into the 'store' algorithm, not in the 'test'
 */
class TwoSumLinearImpl implements TwoSum {

  private final Set<Integer> internalStore = new HashSet<Integer>();
  private final Set<Integer> sums = new HashSet<Integer>();

  public void store(int input) {
    if (internalStore.contains(input)) return; // We already have it

    // We calculate all the sums upon storage
    for (int value : internalStore) {
      sums.add(input + value);
    }

    // Add it to the store
    internalStore.add(input);
  }

  public boolean test(int test) {
    return sums.contains(test);
  }
}

/**
 * Implementation with O(1) complexity on 'store'
 * and disastrous O(n^2) complexity on 'test'.
 *
 * Focuses all the logic into the 'test' algorithm, not in the 'store'
 */
class TwoSumN2Impl implements TwoSum {

  // Having a list gives problems w/ duplicates
  private List<Integer> internalStore = new ArrayList<Integer>();
  private Set<Integer> cache = new HashSet<Integer>();

  public void store(int input) {
    internalStore.add(input);
  }

  public boolean test(int test) {
    // Enhancement which brings recurring cases to a O(1)
    if (cache.contains(test)) {
      return true;
    }

    for (int i = 0; i < internalStore.size(); i++) {
      for (int j = i+1; j < internalStore.size(); j++) {
        int sum = internalStore.get(i) + internalStore.get(j);
        if(sum == test) {
          cache.add(test);
          return true;
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
