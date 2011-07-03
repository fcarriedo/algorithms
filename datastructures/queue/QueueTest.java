import java.util.List;
import java.util.ArrayList;

public class QueueTest {
  public static void main(String[] args) {
    Queue<Integer> myQueue = new QueueImpl<Integer>();
    myQueue.push(4);
    myQueue.push(7);
    myQueue.push(9);

    Assert.assertTrue( myQueue.top() == 9 );
    Assert.assertTrue( myQueue.pop() == 9 );
    Assert.assertTrue( myQueue.pop() == 7 );
    Assert.assertTrue( myQueue.top() == 4 );
    Assert.assertTrue( myQueue.pop() == 4 );
  }
}


/**
 * Simple thread safe implementation of a Queue
 * backed by a list => All access to a shared variable
 * is synchronized.
 */
class QueueImpl<T> implements Queue<T> {

  private final List<T> queue = new ArrayList<T>();

  public synchronized void push(T elem) {
    queue.add(elem);
  }

  public synchronized T pop() {
    return queue.remove( queue.size()-1 );
  }

  public synchronized T top() {
    return queue.get( queue.size()-1 );
  }
}

/**
 * Defines the basic contract of a Queue
 */
interface Queue<T> {
  void push(T elem);
  T pop();
  T top();
}


/**
 * Minimal testing library
 */
class Assert {

  static void assertTrue(boolean bool) {
    if(!bool) {
      throw new AssertionError("Expected 'true' but got 'false'");
    }
  }

  static void fail(String msg) {
    throw new AssertError(msg);
  }
}

class AssertError extends RuntimeException {
  AssertError(String msg) {
    super(msg);
  }
}
